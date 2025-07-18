package vn.hyperlogy.smartvendingmachinev2.core.serial_port

import android.util.Log

data class Device(
        var path: String = "",
        var baudrate: String = ""
) {
    init {
        Log.d("DEVICE", "$path --- $baudrate")
    }

    override fun toString(): String {
        return "Device(path='$path', baudrate='$baudrate')"
    }
}