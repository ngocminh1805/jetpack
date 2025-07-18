package vn.hyperlogy.smartvendingmachinev2.core.serial_port

import android.os.HandlerThread
import android.serialport.SerialPort
import android.util.Log
import com.licheedev.hwutils.ByteUtil
import io.reactivex.Observable
import io.reactivex.ObservableEmitter
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import java.io.File
import java.io.IOException
import java.io.OutputStream

object SerialPortManager {

    private const val TAG = "SerialPortManager"

    private var mSerialPort: SerialPort? = null
    private var mReadThread: SerialReadThread? = null
    private var mOutputStream: OutputStream? = null
    private var mWriteThread: HandlerThread? = null
    private var mSendScheduler = AndroidSchedulers.mainThread() // fallback

    fun open(device: Device): SerialPort? {
        return open(device.path, device.baudrate)
    }

    fun open(devicePath: String, baudrateString: String): SerialPort? {
        if (mSerialPort != null) {
            close()
        }

        return try {
            val device = File(devicePath)
            val baudrate = baudrateString.toInt()
            mSerialPort = SerialPort(device, baudrate)

            mReadThread = SerialReadThread(mSerialPort!!.inputStream).apply { start() }
            mOutputStream = mSerialPort!!.outputStream

            mWriteThread = HandlerThread("write-thread").apply {
                start()
                mSendScheduler = AndroidSchedulers.from(looper)
            }

            mSerialPort
        } catch (t: Throwable) {
            Log.e(TAG, "Failed to open serial port", t)
            close()
            null
        }
    }

    fun close() {
        mReadThread?.close()
        mOutputStream?.runCatching { close() }

        mWriteThread?.quit()

        mSerialPort?.close()
        mSerialPort = null
    }

    private fun sendData(data: ByteArray) {
        mOutputStream?.write(data)
    }

    private fun rxSendData(data: ByteArray): Observable<Unit> {
        return Observable.create { emitter: ObservableEmitter<Unit> ->
            try {
                sendData(data)
                emitter.onNext(Unit)
            } catch (e: Exception) {
                Log.e(TAG, "Failed to send: ${ByteUtil.bytes2HexStr(data)}", e)
                if (!emitter.isDisposed) {
                    emitter.onError(e)
                    return@create
                }
            }
            emitter.onComplete()
        }
    }

    fun sendCommand(command: String) {
        if (command.isNotEmpty()) {
            val bytes = ByteUtil.hexStr2bytes(command)
            rxSendData(bytes)
                .subscribeOn(mSendScheduler)
                .subscribe(object : io.reactivex.Observer<Unit> {
                    override fun onSubscribe(d: Disposable) {
                        Log.d(TAG, "send Command onSubscribe: $d")
                    }

                    override fun onNext(t: Unit) {
                        Log.d(TAG, "send Command onNext")
                    }

                    override fun onError(e: Throwable) {
                        Log.e(TAG, "send Command onError", e)
                    }

                    override fun onComplete() {
                        Log.d(TAG, "send Command onComplete")
                    }
                })
        }
    }
}
