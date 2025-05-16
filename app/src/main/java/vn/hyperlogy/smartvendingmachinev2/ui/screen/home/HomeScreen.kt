package vn.hyperlogy.smartvendingmachinev2.ui.screen.home


import androidx.compose.runtime.*
import androidx.compose.material3.*
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.*
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import vn.hyperlogy.smartvendingmachinev2.data.example.ProductExample

import vn.hyperlogy.smartvendingmachinev2.ui.screen.home.component.AutoScrollList
import vn.hyperlogy.smartvendingmachinev2.model.*
import vn.hyperlogy.smartvendingmachinev2.ui.navigation.NavigationRoutes
import vn.hyperlogy.smartvendingmachinev2.ui.screen.home.component.AdBannerCarousel
import vn.hyperlogy.smartvendingmachinev2.ui.screen.home.component.StatusBar
import vn.hyperlogy.smartvendingmachinev2.utils.LocalAppNavController


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen() {
    val navController = LocalAppNavController.current

    Scaffold(
        topBar = { StatusBar() },
        floatingActionButton = {
            FloatingActionButton(onClick = {
                navController.navigate(
                    NavigationRoutes.Setting.name
                )
            }){ }
        },
        content = { paddingValues ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
            ) {
                AdBannerCarousel(
                    imageUrls = listOf(
                        "https://phongvu.vn/cong-nghe/wp-content/uploads/2024/09/130-hinh-nen-may-tinh-4k-89-1024x640.jpg",
                        "https://cdn.wallpapersafari.com/27/63/bKiHZm.jpg",
                        "https://thiepmung.com/images/theme/tai-hinh-nen-hoang-hon-lang-man-cho-may-tinh56444315a1f24.jpg"
                    )
                )
                AutoScrollList(
                    products = ProductExample().products,
                    isAutoScrollEnabled = true,
                    scrollIntervalMillis = 100L
                )

            }
        }
    )
}


@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    HomeScreen()
}