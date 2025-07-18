package vn.hyperlogy.smartvendingmachinev2.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import vn.hyperlogy.smartvendingmachinev2.ui.screen.home.HomeScreen
import vn.hyperlogy.smartvendingmachinev2.ui.screen.setting.SettingScreen
import vn.hyperlogy.smartvendingmachinev2.core.LocalAppNavController


@Composable
fun MainNavigation() {
    val navController = rememberNavController()

    CompositionLocalProvider(LocalAppNavController provides navController) {
        NavHost(navController = navController, startDestination = NavigationRoutes.Home.name) {
            composable(NavigationRoutes.Home.name) {
                HomeScreen()
            }

            composable(NavigationRoutes.Setting.name) {
                SettingScreen()
            }
        }
    }

}