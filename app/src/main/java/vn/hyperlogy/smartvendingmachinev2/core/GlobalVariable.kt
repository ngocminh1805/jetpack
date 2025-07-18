package vn.hyperlogy.smartvendingmachinev2.core

import androidx.compose.runtime.staticCompositionLocalOf
import androidx.navigation.NavHostController


val LocalAppNavController = staticCompositionLocalOf<NavHostController> {
    error("NavController not provided")
}

