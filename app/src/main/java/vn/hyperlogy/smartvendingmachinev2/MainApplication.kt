package vn.hyperlogy.smartvendingmachinev2

import android.app.Application
import vn.hyperlogy.smartvendingmachinev2.core.AppController

class MainApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        AppController.initSerial("/dev/ttyS0", "9600")

    }

    override fun onTerminate() {
        super.onTerminate()
    }
}