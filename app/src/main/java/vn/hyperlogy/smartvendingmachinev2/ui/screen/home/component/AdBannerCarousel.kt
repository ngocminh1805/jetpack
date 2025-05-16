package vn.hyperlogy.smartvendingmachinev2.ui.screen.home.component

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


@Composable
fun AdBannerCarousel(
    imageUrls: List<String>, // URL ảnh
    modifier: Modifier = Modifier,
    slideDuration: Long = 3000L
) {
    val pagerState = rememberPagerState(initialPage = 0, pageCount = { imageUrls.size })
    val coroutineScope = rememberCoroutineScope()

    val screenHeight = LocalConfiguration.current.screenHeightDp.dp
    val bannerHeight = screenHeight / 3

    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(bannerHeight)
    ) {
        val pageCount = imageUrls.size

        HorizontalPager(
            state = pagerState,
            modifier = Modifier.fillMaxSize()
        ) { page ->
            AsyncImage(
                model = imageUrls[page],
                contentDescription = "Ad Image $page",
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize()
            )
        }

        LaunchedEffect(Unit) {
            while (true) {
                delay(slideDuration)
                val nextPage = (pagerState.currentPage + 1) % pageCount
                coroutineScope.launch {
                    pagerState.animateScrollToPage(nextPage)
                }
            }
        }
    }
}
