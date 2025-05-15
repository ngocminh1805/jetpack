package vn.hyperlogy.smartvendingmachinev2.ui.component

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import vn.hyperlogy.smartvendingmachinev2.model.*


@SuppressLint("UnusedBoxWithConstraintsScope")
@Composable
fun AutoScrollList(
    products: List<Product>,
    isAutoScrollEnabled: Boolean,
    modifier: Modifier = Modifier,
    scrollIntervalMillis: Long = 3000L
) {
    val groupedProducts = products.chunked(2) // 2 sản phẩm trên 1 cột
    val listState = rememberLazyListState()
    var isScrollingForward by remember { mutableStateOf(true) }

    LaunchedEffect(isAutoScrollEnabled) {
        while (isAutoScrollEnabled && groupedProducts.isNotEmpty()) {
            delay(scrollIntervalMillis)

            val currentIndex = listState.firstVisibleItemIndex
            val nextIndex = when {
                isScrollingForward && currentIndex < groupedProducts.lastIndex -> currentIndex + 1
                !isScrollingForward && currentIndex > 0 -> currentIndex - 1
                else -> currentIndex // giữ nguyên nếu không thể cuộn
            }

            // Cập nhật hướng scroll nếu đến cuối hoặc đầu
            if (nextIndex == `groupedProducts`.lastIndex) {
                isScrollingForward = false
            } else if (nextIndex == 0) {
                isScrollingForward = true
            }

            listState.animateScrollToItem(nextIndex)
        }
    }

    BoxWithConstraints(modifier = Modifier.fillMaxHeight()) {

        val itemHeight = (maxHeight - 48.dp) / 2
        val itemWidth = itemHeight * (2f / 3f)

        LazyRow(
            state = listState,
            modifier = modifier
                .fillMaxWidth()
                .fillMaxHeight(1f),
            contentPadding = PaddingValues(horizontal = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp),

            ) {

            items(groupedProducts.size) { groupIndex ->
                Column(
                    verticalArrangement = Arrangement.spacedBy(16.dp),
                    modifier = Modifier
                        .padding(vertical = 8.dp)
                ) {
                    groupedProducts[groupIndex].forEach { product ->
                        ProductCard(
                            product = product,
                            modifier = Modifier
                                .height(itemHeight)
                                .width(itemWidth)
                                .padding(8.dp)
                        )
                    }
                }
            }
        }
    }

}


@Preview
@Composable
fun AutoScrollListPreview() {
    AutoScrollList(products = listOf(), isAutoScrollEnabled = true)
}


