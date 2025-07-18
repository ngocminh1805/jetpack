package vn.hyperlogy.smartvendingmachinev2.core

import android.util.Log
import vn.hyperlogy.smartvendingmachinev2.core.serial_port.SerialPortManager


object AppController  {
    private const val TAG = "AppController"
    private var isInitialized = false

    fun initSerial(devicePath: String = "/dev/ttyS1", baudrate: String = "9600") {
        if (isInitialized) return

        val serialPort = SerialPortManager.open(devicePath, baudrate)
        if (serialPort != null) {
            Log.d(TAG, "Serial port initialized successfully")
            isInitialized = true
        } else {
            Log.e(TAG, "Failed to open serial port")
        }
    }

    fun sendCommand(command: String) {
        if (!isInitialized) {
            Log.e(TAG, "Serial port not initialized")
            return
        }

        SerialPortManager.sendCommand(command)
    }

    fun shutdown() {
        SerialPortManager.close()
        isInitialized = false
        Log.d(TAG, "Serial port closed")
    }
}