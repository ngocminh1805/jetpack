package vn.hyperlogy.smartvendingmachinev2.core.serial_port

import android.os.SystemClock
import android.util.Log
import com.licheedev.hwutils.ByteUtil
import java.io.BufferedInputStream
import java.io.IOException
import java.io.InputStream

import kotlin.jvm.Volatile;

class SerialReadThread(inputStream: InputStream) : Thread() {

    companion object {
        private const val TAG = "SerialReadThread"
    }

    private val mInputStream = BufferedInputStream(inputStream)

    @Volatile
    private var running = true

    override fun run() {
        val received = ByteArray(1024)

        while (running && !isInterrupted) {
            try {
                val available = mInputStream.available()

                if (available > 0) {
                    val size = mInputStream.read(received)
                    if (size > 0) {
                        onDataReceive(received, size)
                    }
                } else {
                    SystemClock.sleep(1)
                }
            } catch (e: IOException) {
                Log.e(TAG, "IOException in read loop", e)
                break
            }
        }

        Log.e(TAG, "Read thread exited.")
    }

    private fun onDataReceive(received: ByteArray, size: Int) {
        val hexStr = ByteUtil.bytes2HexStr(received, 0, size)
        Log.d(TAG, "onDataReceive: $hexStr")
    }

    fun close() {
        running = false
        try {
            mInputStream.close()
        } catch (e: IOException) {
            Log.e(TAG, "Error closing input stream", e)
        } finally {
            interrupt()
        }
    }
}
