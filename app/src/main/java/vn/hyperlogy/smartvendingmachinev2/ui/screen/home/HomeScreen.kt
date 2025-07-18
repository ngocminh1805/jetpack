package vn.hyperlogy.smartvendingmachinev2.ui.screen.home


import androidx.compose.runtime.*
import androidx.compose.material3.*
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.*
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import kotlinx.coroutines.delay

import vn.hyperlogy.smartvendingmachinev2.ui.screen.home.component.AutoScrollList
import vn.hyperlogy.smartvendingmachinev2.ui.navigation.NavigationRoutes
import vn.hyperlogy.smartvendingmachinev2.ui.screen.home.component.AdBannerCarousel
import vn.hyperlogy.smartvendingmachinev2.ui.screen.home.component.StatusBar
import vn.hyperlogy.smartvendingmachinev2.core.LocalAppNavController
import vn.hyperlogy.smartvendingmachinev2.ui.screen.home.component.CartModal


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(viewModel: HomeViewModel = viewModel()) {
    val navController = LocalAppNavController.current
    val productList by viewModel.productList.collectAsState()
    val isModalOpen by viewModel.isModalOpen.collectAsState()

    LaunchedEffect(Unit) {
        delay(10000)
        viewModel.loadProducts()
    }

    Scaffold(
        topBar = { StatusBar() },
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
                    products = productList,
                    isAutoScrollEnabled = true,
                    scrollIntervalMillis = 100L
                )

            }
        }
    )

    CartModal(isModalOpen)
}


@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    HomeScreen()
}