package vn.hyperlogy.smartvendingmachinev2.ui.screen.home.component

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.ExperimentalFoundationApi

import androidx.compose.foundation.gestures.animateScrollBy
import androidx.compose.foundation.interaction.DragInteraction
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.PressInteraction
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import vn.hyperlogy.smartvendingmachinev2.model.*


@OptIn(ExperimentalFoundationApi::class)
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
    val coroutineScope = rememberCoroutineScope()

    val interactionSource = remember { MutableInteractionSource() }
    var isAutoScroll by remember { mutableStateOf(true) }
    var lastInteractionTime by remember { mutableStateOf(System.currentTimeMillis()) }



    LaunchedEffect(interactionSource) {
        interactionSource.interactions.collect { interaction ->

            Log.d("AutoScrollList", "interaction: $interaction")

            when (interaction) {
                is PressInteraction.Press,
                is DragInteraction.Start -> {
                    isAutoScroll = false
                    lastInteractionTime = System.currentTimeMillis()
                }

                is PressInteraction.Release,
                is DragInteraction.Stop,
                is DragInteraction.Cancel -> {
                    lastInteractionTime = System.currentTimeMillis()
                }
            }
        }
    }



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
            if (nextIndex + 1 >= groupedProducts.lastIndex) {
                isScrollingForward = false
            } else if (nextIndex == 0) {
                isScrollingForward = true
            }

            coroutineScope.launch {
                listState.animateScrollBy(if (isScrollingForward) 10f else -10f)
            }
        }
    }

    BoxWithConstraints(modifier = modifier.fillMaxHeight()) {

        val itemHeight = (maxHeight - 48.dp) / 2
        val itemWidth = itemHeight * (2f / 3f)

        LazyRow(
            state = listState,
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(1f)
            ,
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


