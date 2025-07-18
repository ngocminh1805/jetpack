package vn.hyperlogy.smartvendingmachinev2.core.serial_port.util

object EventHex {

    // Send
    const val SEND_READ_TEMPERATURE = "00ffdc2355aa"
    const val GET_SERIAL_COMMAND = "00ffee11aa55"
    const val GET_PASSWORD_COMMAND = "00ffef10aa55"
    const val POWER_ON_COOLER = "00ffbb4401fe"
    const val POWER_OFF_COOLER = "00ffbb4400ff"
    const val REQUEST_COOLER_STATUS = "00ffbb4410ef"

    // Receive
    const val RECEIVE_DETECT_PRODUCT_DISPENSE = "005d00aa07"
    const val RECEIVE_DOES_NOT_DETECT_PRODUCT_DISPENSE = "005d00005d"
    const val TEST_MOTOR_SUCCESS = "005d01fe5c"
    const val TEST_MOTOR_FAIL = "005d00ff5c"
    const val GOOD_IN_TRAY = "00ab00ab56"
    const val NOT_GOOD_IN_TRAY = "00aa00aa54"
    const val GOOD_IN_TRAY_TIME_OUT = "00ac00ac58"
    const val STUCK_LIFTING_MACHINE = "00ad00ad5a"
    const val COOLER_STATUS_ON = "00cc4400ef"
    const val COOLER_STATUS_OFF = "00cc4411ef"

    // UPS
    const val OPEN_DOOR_UPS = "cd03fc"
    const val CLOSE_DOOR_UPS = "cd04fb"
    const val DETECT_PERSON = "ef01fe"

    // Generate hex code for setting temperature
    fun generateTemperature(temp: Int): String {
        val hexTemp = temp.coerceIn(0, 255).toString(16).padStart(2, '0').uppercase()
        val hexComplement = (255 - temp).toString(16).padStart(2, '0').uppercase()
        return ("00FFCE31$hexTemp$hexComplement").lowercase()
    }
}
