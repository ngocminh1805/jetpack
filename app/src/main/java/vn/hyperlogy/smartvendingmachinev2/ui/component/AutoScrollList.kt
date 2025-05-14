package vn.hyperlogy.smartvendingmachinev2.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.Alignment
import coil.compose.AsyncImage
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

data class Product(
    val name: String,
    val imageUrl: String
)

@Composable
fun AutoScrollList(
    products: List<Product>,
    isAutoScrollEnabled: Boolean,
    modifier: Modifier = Modifier,
    scrollIntervalMillis: Long = 3000L
) {
    val groupedProducts = products.chunked(2) // 2 sản phẩm trên 1 cột
    val listState = rememberLazyListState()
    val coroutineScope = rememberCoroutineScope()
    var isScrollingForward by remember { mutableStateOf(true) }

    LaunchedEffect(isAutoScrollEnabled) {
        while (isAutoScrollEnabled) {
            delay(scrollIntervalMillis)

            val currentIndex = listState.firstVisibleItemIndex
            val nextIndex = if (isScrollingForward) currentIndex + 1 else currentIndex - 1

            if (nextIndex >= groupedProducts.size) {
                isScrollingForward = false
            } else if (nextIndex < 0) {
                isScrollingForward = true
            }

            val targetIndex = when {
                nextIndex >= groupedProducts.size -> groupedProducts.size - 1
                nextIndex < 0 -> 0
                else -> nextIndex
            }

            coroutineScope.launch {
                listState.animateScrollToItem(targetIndex)
            }
        }
    }

    LazyRow(
        state = listState,
        modifier = modifier
            .fillMaxWidth()
            .height(340.dp), // đủ để chứa 2 sản phẩm
        contentPadding = PaddingValues(horizontal = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        items(groupedProducts.size) { groupIndex ->
            Column(
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                groupedProducts[groupIndex].forEach { product ->
                    ProductCard(product = product)
                }
            }
        }
    }
}

@Composable
fun ProductCard(product: Product) {
    Column(
        modifier = Modifier
            .width(160.dp)
            .background(Color(0xFFF5F5F5), shape = RoundedCornerShape(12.dp))
            .padding(12.dp)
    ) {
        AsyncImage(
            model = product.imageUrl,
            contentDescription = product.name,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .height(100.dp)
                .fillMaxWidth()
//                .clip(RoundedCornerShape(8.dp))
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = product.name,
            style = MaterialTheme.typography.titleSmall,
            color = Color.Black
        )
    }
}

