package vn.hyperlogy.smartvendingmachinev2.ui.screen.home


import androidx.compose.runtime.*
import androidx.compose.material3.*
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

import androidx.compose.foundation.pager.HorizontalPager
import kotlinx.coroutines.delay
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.layout.ContentScale
import coil.compose.AsyncImage
import kotlinx.coroutines.launch

import androidx.compose.foundation.pager.rememberPagerState
import vn.hyperlogy.smartvendingmachinev2.ui.component.AutoScrollList
import vn.hyperlogy.smartvendingmachinev2.model.*


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen() {

    val products = listOf(
        Product(
            name = "Sản phẩm 1",
            imageUrl = "https://images.pexels.com/photos/24860314/pexels-photo-24860314/free-photo-of-ly-c-c-chen-kinh.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500",
            slotNo = 1,
            stock = 5,
            quantity = 5,
            slotNumber = "AA",
            price = 5000,
            keyNum = "AA",
            id = "ewdasdasda"
        ),
        Product(
            name = "Sản phẩm 2",
            imageUrl = "https://images.pexels.com/photos/24860314/pexels-photo-24860314/free-photo-of-ly-c-c-chen-kinh.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500",
            slotNo = 1,
            stock = 5,
            quantity = 5,
            slotNumber = "AA",
            price = 5000,
            keyNum = "AA",
            id = "ewdasdasda"
        ),
        Product(
            name = "Sản phẩm 3",
            imageUrl = "https://images.pexels.com/photos/24860314/pexels-photo-24860314/free-photo-of-ly-c-c-chen-kinh.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500",
            slotNo = 1,
            stock = 5,
            quantity = 5,
            slotNumber = "AA",
            price = 5000,
            keyNum = "AA",
            id = "ewdasdasda"
        ),
        Product(
            name = "Sản phẩm 4",
            imageUrl = "https://images.pexels.com/photos/24860314/pexels-photo-24860314/free-photo-of-ly-c-c-chen-kinh.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500",
            slotNo = 1,
            stock = 5,
            quantity = 5,
            slotNumber = "AA",
            price = 5000,
            keyNum = "AA",
            id = "ewdasdasda"
        ),
        Product(
            name = "Sản phẩm 1",
            imageUrl = "https://images.pexels.com/photos/24860314/pexels-photo-24860314/free-photo-of-ly-c-c-chen-kinh.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500",
            slotNo = 1,
            stock = 5,
            quantity = 5,
            slotNumber = "AA",
            price = 5000,
            keyNum = "AA",
            id = "ewdasdasda"
        ),
        Product(
            name = "Sản phẩm 2",
            imageUrl = "https://images.pexels.com/photos/24860314/pexels-photo-24860314/free-photo-of-ly-c-c-chen-kinh.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500",
            slotNo = 1,
            stock = 5,
            quantity = 5,
            slotNumber = "AA",
            price = 5000,
            keyNum = "AA",
            id = "ewdasdasda"
        ),
        Product(
            name = "Sản phẩm 3",
            imageUrl = "https://images.pexels.com/photos/24860314/pexels-photo-24860314/free-photo-of-ly-c-c-chen-kinh.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500",
            slotNo = 1,
            stock = 5,
            quantity = 5,
            slotNumber = "AA",
            price = 5000,
            keyNum = "AA",
            id = "ewdasdasda"
        ),
        Product(
            name = "Sản phẩm 4",
            imageUrl = "https://images.pexels.com/photos/24860314/pexels-photo-24860314/free-photo-of-ly-c-c-chen-kinh.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500",
            slotNo = 1,
            stock = 5,
            quantity = 5,
            slotNumber = "AA",
            price = 5000,
            keyNum = "AA",
            id = "ewdasdasda"
        ),
        Product(
            name = "Sản phẩm 1",
            imageUrl = "https://images.pexels.com/photos/24860314/pexels-photo-24860314/free-photo-of-ly-c-c-chen-kinh.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500",
            slotNo = 1,
            stock = 5,
            quantity = 5,
            slotNumber = "AA",
            price = 5000,
            keyNum = "AA",
            id = "ewdasdasda"
        ),
        Product(
            name = "Sản phẩm 2",
            imageUrl = "https://images.pexels.com/photos/24860314/pexels-photo-24860314/free-photo-of-ly-c-c-chen-kinh.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500",
            slotNo = 1,
            stock = 5,
            quantity = 5,
            slotNumber = "AA",
            price = 5000,
            keyNum = "AA",
            id = "ewdasdasda"
        ),
        Product(
            name = "Sản phẩm 3",
            imageUrl = "https://images.pexels.com/photos/24860314/pexels-photo-24860314/free-photo-of-ly-c-c-chen-kinh.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500",
            slotNo = 1,
            stock = 5,
            quantity = 5,
            slotNumber = "AA",
            price = 5000,
            keyNum = "AA",
            id = "ewdasdasda"
        ),
        Product(
            name = "Sản phẩm 4",
            imageUrl = "https://images.pexels.com/photos/24860314/pexels-photo-24860314/free-photo-of-ly-c-c-chen-kinh.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500",
            slotNo = 1,
            stock = 5,
            quantity = 5,
            slotNumber = "AA",
            price = 5000,
            keyNum = "AA",
            id = "ewdasdasda"
        ),
        Product(
            name = "Sản phẩm 1",
            imageUrl = "https://images.pexels.com/photos/24860314/pexels-photo-24860314/free-photo-of-ly-c-c-chen-kinh.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500",
            slotNo = 1,
            stock = 5,
            quantity = 5,
            slotNumber = "AA",
            price = 5000,
            keyNum = "AA",
            id = "ewdasdasda"
        ),
        Product(
            name = "Sản phẩm 2",
            imageUrl = "https://images.pexels.com/photos/24860314/pexels-photo-24860314/free-photo-of-ly-c-c-chen-kinh.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500",
            slotNo = 1,
            stock = 5,
            quantity = 5,
            slotNumber = "AA",
            price = 5000,
            keyNum = "AA",
            id = "ewdasdasda"
        ),
        Product(
            name = "Sản phẩm 3",
            imageUrl = "https://images.pexels.com/photos/24860314/pexels-photo-24860314/free-photo-of-ly-c-c-chen-kinh.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500",
            slotNo = 1,
            stock = 5,
            quantity = 5,
            slotNumber = "AA",
            price = 5000,
            keyNum = "AA",
            id = "ewdasdasda"
        ),
        Product(
            name = "Sản phẩm 4",
            imageUrl = "https://images.pexels.com/photos/24860314/pexels-photo-24860314/free-photo-of-ly-c-c-chen-kinh.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500",
            slotNo = 1,
            stock = 5,
            quantity = 5,
            slotNumber = "AA",
            price = 5000,
            keyNum = "AA",
            id = "ewdasdasda"
        ),
        Product(
            name = "Sản phẩm 1",
            imageUrl = "https://images.pexels.com/photos/24860314/pexels-photo-24860314/free-photo-of-ly-c-c-chen-kinh.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500",
            slotNo = 1,
            stock = 5,
            quantity = 5,
            slotNumber = "AA",
            price = 5000,
            keyNum = "AA",
            id = "ewdasdasda"
        ),
        Product(
            name = "Sản phẩm 2",
            imageUrl = "https://images.pexels.com/photos/24860314/pexels-photo-24860314/free-photo-of-ly-c-c-chen-kinh.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500",
            slotNo = 1,
            stock = 5,
            quantity = 5,
            slotNumber = "AA",
            price = 5000,
            keyNum = "AA",
            id = "ewdasdasda"
        ),
        Product(
            name = "Sản phẩm 3",
            imageUrl = "https://images.pexels.com/photos/24860314/pexels-photo-24860314/free-photo-of-ly-c-c-chen-kinh.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500",
            slotNo = 1,
            stock = 5,
            quantity = 5,
            slotNumber = "AA",
            price = 5000,
            keyNum = "AA",
            id = "ewdasdasda"
        ),
        Product(
            name = "Sản phẩm 4",
            imageUrl = "https://images.pexels.com/photos/24860314/pexels-photo-24860314/free-photo-of-ly-c-c-chen-kinh.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500",
            slotNo = 1,
            stock = 5,
            quantity = 5,
            slotNumber = "AA",
            price = 5000,
            keyNum = "AA",
            id = "ewdasdasda"
        ),
        Product(
            name = "Sản phẩm 1",
            imageUrl = "https://images.pexels.com/photos/24860314/pexels-photo-24860314/free-photo-of-ly-c-c-chen-kinh.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500",
            slotNo = 1,
            stock = 5,
            quantity = 5,
            slotNumber = "AA",
            price = 5000,
            keyNum = "AA",
            id = "ewdasdasda"
        ),
        Product(
            name = "Sản phẩm 2",
            imageUrl = "https://images.pexels.com/photos/24860314/pexels-photo-24860314/free-photo-of-ly-c-c-chen-kinh.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500",
            slotNo = 1,
            stock = 5,
            quantity = 5,
            slotNumber = "AA",
            price = 5000,
            keyNum = "AA",
            id = "ewdasdasda"
        ),
        Product(
            name = "Sản phẩm 3",
            imageUrl = "https://images.pexels.com/photos/24860314/pexels-photo-24860314/free-photo-of-ly-c-c-chen-kinh.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500",
            slotNo = 1,
            stock = 5,
            quantity = 5,
            slotNumber = "AA",
            price = 5000,
            keyNum = "AA",
            id = "ewdasdasda"
        ),
        Product(
            name = "Sản phẩm 4",
            imageUrl = "https://images.pexels.com/photos/24860314/pexels-photo-24860314/free-photo-of-ly-c-c-chen-kinh.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500",
            slotNo = 1,
            stock = 5,
            quantity = 5,
            slotNumber = "AA",
            price = 5000,
            keyNum = "AA",
            id = "ewdasdasda"
        ),
        Product(
            name = "Sản phẩm 1",
            imageUrl = "https://images.pexels.com/photos/24860314/pexels-photo-24860314/free-photo-of-ly-c-c-chen-kinh.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500",
            slotNo = 1,
            stock = 5,
            quantity = 5,
            slotNumber = "AA",
            price = 5000,
            keyNum = "AA",
            id = "ewdasdasda"
        ),
        Product(
            name = "Sản phẩm 2",
            imageUrl = "https://images.pexels.com/photos/24860314/pexels-photo-24860314/free-photo-of-ly-c-c-chen-kinh.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500",
            slotNo = 1,
            stock = 5,
            quantity = 5,
            slotNumber = "AA",
            price = 5000,
            keyNum = "AA",
            id = "ewdasdasda"
        ),
        Product(
            name = "Sản phẩm 3",
            imageUrl = "https://images.pexels.com/photos/24860314/pexels-photo-24860314/free-photo-of-ly-c-c-chen-kinh.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500",
            slotNo = 1,
            stock = 5,
            quantity = 5,
            slotNumber = "AA",
            price = 5000,
            keyNum = "AA",
            id = "ewdasdasda"
        ),
        Product(
            name = "Sản phẩm 4",
            imageUrl = "https://images.pexels.com/photos/24860314/pexels-photo-24860314/free-photo-of-ly-c-c-chen-kinh.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500",
            slotNo = 1,
            stock = 5,
            quantity = 5,
            slotNumber = "AA",
            price = 5000,
            keyNum = "AA",
            id = "ewdasdasda"
        ),
        Product(
            name = "Sản phẩm 1",
            imageUrl = "https://images.pexels.com/photos/24860314/pexels-photo-24860314/free-photo-of-ly-c-c-chen-kinh.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500",
            slotNo = 1,
            stock = 5,
            quantity = 5,
            slotNumber = "AA",
            price = 5000,
            keyNum = "AA",
            id = "ewdasdasda"
        ),
        Product(
            name = "Sản phẩm 2",
            imageUrl = "https://images.pexels.com/photos/24860314/pexels-photo-24860314/free-photo-of-ly-c-c-chen-kinh.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500",
            slotNo = 1,
            stock = 5,
            quantity = 5,
            slotNumber = "AA",
            price = 5000,
            keyNum = "AA",
            id = "ewdasdasda"
        ),
        Product(
            name = "Sản phẩm 3",
            imageUrl = "https://images.pexels.com/photos/24860314/pexels-photo-24860314/free-photo-of-ly-c-c-chen-kinh.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500",
            slotNo = 1,
            stock = 5,
            quantity = 5,
            slotNumber = "AA",
            price = 5000,
            keyNum = "AA",
            id = "ewdasdasda"
        ),
        Product(
            name = "Sản phẩm 4",
            imageUrl = "https://images.pexels.com/photos/24860314/pexels-photo-24860314/free-photo-of-ly-c-c-chen-kinh.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500",
            slotNo = 1,
            stock = 5,
            quantity = 5,
            slotNumber = "AA",
            price = 5000,
            keyNum = "AA",
            id = "ewdasdasda"
        ),
        Product(
            name = "Sản phẩm 1",
            imageUrl = "https://images.pexels.com/photos/24860314/pexels-photo-24860314/free-photo-of-ly-c-c-chen-kinh.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500",
            slotNo = 1,
            stock = 5,
            quantity = 5,
            slotNumber = "AA",
            price = 5000,
            keyNum = "AA",
            id = "ewdasdasda"
        ),
        Product(
            name = "Sản phẩm 2",
            imageUrl = "https://images.pexels.com/photos/24860314/pexels-photo-24860314/free-photo-of-ly-c-c-chen-kinh.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500",
            slotNo = 1,
            stock = 5,
            quantity = 5,
            slotNumber = "AA",
            price = 5000,
            keyNum = "AA",
            id = "ewdasdasda"
        ),
        Product(
            name = "Sản phẩm 3",
            imageUrl = "https://images.pexels.com/photos/24860314/pexels-photo-24860314/free-photo-of-ly-c-c-chen-kinh.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500",
            slotNo = 1,
            stock = 5,
            quantity = 5,
            slotNumber = "AA",
            price = 5000,
            keyNum = "AA",
            id = "ewdasdasda"
        ),
        Product(
            name = "Sản phẩm 4",
            imageUrl = "https://images.pexels.com/photos/24860314/pexels-photo-24860314/free-photo-of-ly-c-c-chen-kinh.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500",
            slotNo = 1,
            stock = 5,
            quantity = 5,
            slotNumber = "AA",
            price = 5000,
            keyNum = "AA",
            id = "ewdasdasda"
        ),
        Product(
            name = "Sản phẩm 1",
            imageUrl = "https://images.pexels.com/photos/24860314/pexels-photo-24860314/free-photo-of-ly-c-c-chen-kinh.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500",
            slotNo = 1,
            stock = 5,
            quantity = 5,
            slotNumber = "AA",
            price = 5000,
            keyNum = "AA",
            id = "ewdasdasda"
        ),
        Product(
            name = "Sản phẩm 2",
            imageUrl = "https://images.pexels.com/photos/24860314/pexels-photo-24860314/free-photo-of-ly-c-c-chen-kinh.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500",
            slotNo = 1,
            stock = 5,
            quantity = 5,
            slotNumber = "AA",
            price = 5000,
            keyNum = "AA",
            id = "ewdasdasda"
        ),
        Product(
            name = "Sản phẩm 3",
            imageUrl = "https://images.pexels.com/photos/24860314/pexels-photo-24860314/free-photo-of-ly-c-c-chen-kinh.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500",
            slotNo = 1,
            stock = 5,
            quantity = 5,
            slotNumber = "AA",
            price = 5000,
            keyNum = "AA",
            id = "ewdasdasda"
        ),
        Product(
            name = "Sản phẩm 4",
            imageUrl = "https://images.pexels.com/photos/24860314/pexels-photo-24860314/free-photo-of-ly-c-c-chen-kinh.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500",
            slotNo = 1,
            stock = 5,
            quantity = 5,
            slotNumber = "AA",
            price = 5000,
            keyNum = "AA",
            id = "ewdasdasda"
        ),
        Product(
            name = "Sản phẩm 1",
            imageUrl = "https://images.pexels.com/photos/24860314/pexels-photo-24860314/free-photo-of-ly-c-c-chen-kinh.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500",
            slotNo = 1,
            stock = 5,
            quantity = 5,
            slotNumber = "AA",
            price = 5000,
            keyNum = "AA",
            id = "ewdasdasda"
        ),
        Product(
            name = "Sản phẩm 2",
            imageUrl = "https://images.pexels.com/photos/24860314/pexels-photo-24860314/free-photo-of-ly-c-c-chen-kinh.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500",
            slotNo = 1,
            stock = 5,
            quantity = 5,
            slotNumber = "AA",
            price = 5000,
            keyNum = "AA",
            id = "ewdasdasda"
        ),
        Product(
            name = "Sản phẩm 3",
            imageUrl = "https://images.pexels.com/photos/24860314/pexels-photo-24860314/free-photo-of-ly-c-c-chen-kinh.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500",
            slotNo = 1,
            stock = 5,
            quantity = 5,
            slotNumber = "AA",
            price = 5000,
            keyNum = "AA",
            id = "ewdasdasda"
        ),
        Product(
            name = "Sản phẩm 4",
            imageUrl = "https://images.pexels.com/photos/24860314/pexels-photo-24860314/free-photo-of-ly-c-c-chen-kinh.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500",
            slotNo = 1,
            stock = 5,
            quantity = 5,
            slotNumber = "AA",
            price = 5000,
            keyNum = "AA",
            id = "ewdasdasda"
        ),
        Product(
            name = "Sản phẩm 1",
            imageUrl = "https://images.pexels.com/photos/24860314/pexels-photo-24860314/free-photo-of-ly-c-c-chen-kinh.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500",
            slotNo = 1,
            stock = 5,
            quantity = 5,
            slotNumber = "AA",
            price = 5000,
            keyNum = "AA",
            id = "ewdasdasda"
        ),
        Product(
            name = "Sản phẩm 2",
            imageUrl = "https://images.pexels.com/photos/24860314/pexels-photo-24860314/free-photo-of-ly-c-c-chen-kinh.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500",
            slotNo = 1,
            stock = 5,
            quantity = 5,
            slotNumber = "AA",
            price = 5000,
            keyNum = "AA",
            id = "ewdasdasda"
        ),
        Product(
            name = "Sản phẩm 3",
            imageUrl = "https://images.pexels.com/photos/24860314/pexels-photo-24860314/free-photo-of-ly-c-c-chen-kinh.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500",
            slotNo = 1,
            stock = 5,
            quantity = 5,
            slotNumber = "AA",
            price = 5000,
            keyNum = "AA",
            id = "ewdasdasda"
        ),
        Product(
            name = "Sản phẩm 4",
            imageUrl = "https://images.pexels.com/photos/24860314/pexels-photo-24860314/free-photo-of-ly-c-c-chen-kinh.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500",
            slotNo = 1,
            stock = 5,
            quantity = 5,
            slotNumber = "AA",
            price = 5000,
            keyNum = "AA",
            id = "ewdasdasda"
        ),
        Product(
            name = "Sản phẩm 1",
            imageUrl = "https://images.pexels.com/photos/24860314/pexels-photo-24860314/free-photo-of-ly-c-c-chen-kinh.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500",
            slotNo = 1,
            stock = 5,
            quantity = 5,
            slotNumber = "AA",
            price = 5000,
            keyNum = "AA",
            id = "ewdasdasda"
        ),
        Product(
            name = "Sản phẩm 2",
            imageUrl = "https://images.pexels.com/photos/24860314/pexels-photo-24860314/free-photo-of-ly-c-c-chen-kinh.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500",
            slotNo = 1,
            stock = 5,
            quantity = 5,
            slotNumber = "AA",
            price = 5000,
            keyNum = "AA",
            id = "ewdasdasda"
        ),
        Product(
            name = "Sản phẩm 3",
            imageUrl = "https://images.pexels.com/photos/24860314/pexels-photo-24860314/free-photo-of-ly-c-c-chen-kinh.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500",
            slotNo = 1,
            stock = 5,
            quantity = 5,
            slotNumber = "AA",
            price = 5000,
            keyNum = "AA",
            id = "ewdasdasda"
        ),
        Product(
            name = "Sản phẩm 4",
            imageUrl = "https://images.pexels.com/photos/24860314/pexels-photo-24860314/free-photo-of-ly-c-c-chen-kinh.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500",
            slotNo = 1,
            stock = 5,
            quantity = 5,
            slotNumber = "AA",
            price = 5000,
            keyNum = "AA",
            id = "ewdasdasda"
        ),
        Product(
            name = "Sản phẩm 1",
            imageUrl = "https://images.pexels.com/photos/24860314/pexels-photo-24860314/free-photo-of-ly-c-c-chen-kinh.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500",
            slotNo = 1,
            stock = 5,
            quantity = 5,
            slotNumber = "AA",
            price = 5000,
            keyNum = "AA",
            id = "ewdasdasda"
        ),
        Product(
            name = "Sản phẩm 2",
            imageUrl = "https://images.pexels.com/photos/24860314/pexels-photo-24860314/free-photo-of-ly-c-c-chen-kinh.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500",
            slotNo = 1,
            stock = 5,
            quantity = 5,
            slotNumber = "AA",
            price = 5000,
            keyNum = "AA",
            id = "ewdasdasda"
        ),
        Product(
            name = "Sản phẩm 3",
            imageUrl = "https://images.pexels.com/photos/24860314/pexels-photo-24860314/free-photo-of-ly-c-c-chen-kinh.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500",
            slotNo = 1,
            stock = 5,
            quantity = 5,
            slotNumber = "AA",
            price = 5000,
            keyNum = "AA",
            id = "ewdasdasda"
        ),
        Product(
            name = "Sản phẩm 4",
            imageUrl = "https://images.pexels.com/photos/24860314/pexels-photo-24860314/free-photo-of-ly-c-c-chen-kinh.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500",
            slotNo = 1,
            stock = 5,
            quantity = 5,
            slotNumber = "AA",
            price = 5000,
            keyNum = "AA",
            id = "ewdasdasda"
        ),
        Product(
            name = "Sản phẩm 1",
            imageUrl = "https://images.pexels.com/photos/24860314/pexels-photo-24860314/free-photo-of-ly-c-c-chen-kinh.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500",
            slotNo = 1,
            stock = 5,
            quantity = 5,
            slotNumber = "AA",
            price = 5000,
            keyNum = "AA",
            id = "ewdasdasda"
        ),
        Product(
            name = "Sản phẩm 2",
            imageUrl = "https://images.pexels.com/photos/24860314/pexels-photo-24860314/free-photo-of-ly-c-c-chen-kinh.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500",
            slotNo = 1,
            stock = 5,
            quantity = 5,
            slotNumber = "AA",
            price = 5000,
            keyNum = "AA",
            id = "ewdasdasda"
        ),
        Product(
            name = "Sản phẩm 3",
            imageUrl = "https://images.pexels.com/photos/24860314/pexels-photo-24860314/free-photo-of-ly-c-c-chen-kinh.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500",
            slotNo = 1,
            stock = 5,
            quantity = 5,
            slotNumber = "AA",
            price = 5000,
            keyNum = "AA",
            id = "ewdasdasda"
        ),
        Product(
            name = "Sản phẩm 4",
            imageUrl = "https://images.pexels.com/photos/24860314/pexels-photo-24860314/free-photo-of-ly-c-c-chen-kinh.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500",
            slotNo = 1,
            stock = 5,
            quantity = 5,
            slotNumber = "AA",
            price = 5000,
            keyNum = "AA",
            id = "ewdasdasda"
        ),
        Product(
            name = "Sản phẩm 1",
            imageUrl = "https://images.pexels.com/photos/24860314/pexels-photo-24860314/free-photo-of-ly-c-c-chen-kinh.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500",
            slotNo = 1,
            stock = 5,
            quantity = 5,
            slotNumber = "AA",
            price = 5000,
            keyNum = "AA",
            id = "ewdasdasda"
        ),
        Product(
            name = "Sản phẩm 2",
            imageUrl = "https://images.pexels.com/photos/24860314/pexels-photo-24860314/free-photo-of-ly-c-c-chen-kinh.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500",
            slotNo = 1,
            stock = 5,
            quantity = 5,
            slotNumber = "AA",
            price = 5000,
            keyNum = "AA",
            id = "ewdasdasda"
        ),
        Product(
            name = "Sản phẩm 3",
            imageUrl = "https://images.pexels.com/photos/24860314/pexels-photo-24860314/free-photo-of-ly-c-c-chen-kinh.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500",
            slotNo = 1,
            stock = 5,
            quantity = 5,
            slotNumber = "AA",
            price = 5000,
            keyNum = "AA",
            id = "ewdasdasda"
        ),
        Product(
            name = "Sản phẩm 4",
            imageUrl = "https://images.pexels.com/photos/24860314/pexels-photo-24860314/free-photo-of-ly-c-c-chen-kinh.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500",
            slotNo = 1,
            stock = 5,
            quantity = 5,
            slotNumber = "AA",
            price = 5000,
            keyNum = "AA",
            id = "ewdasdasda"
        ),
        Product(
            name = "Sản phẩm 1",
            imageUrl = "https://images.pexels.com/photos/24860314/pexels-photo-24860314/free-photo-of-ly-c-c-chen-kinh.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500",
            slotNo = 1,
            stock = 5,
            quantity = 5,
            slotNumber = "AA",
            price = 5000,
            keyNum = "AA",
            id = "ewdasdasda"
        ),
        Product(
            name = "Sản phẩm 2",
            imageUrl = "https://images.pexels.com/photos/24860314/pexels-photo-24860314/free-photo-of-ly-c-c-chen-kinh.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500",
            slotNo = 1,
            stock = 5,
            quantity = 5,
            slotNumber = "AA",
            price = 5000,
            keyNum = "AA",
            id = "ewdasdasda"
        ),
        Product(
            name = "Sản phẩm 3",
            imageUrl = "https://images.pexels.com/photos/24860314/pexels-photo-24860314/free-photo-of-ly-c-c-chen-kinh.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500",
            slotNo = 1,
            stock = 5,
            quantity = 5,
            slotNumber = "AA",
            price = 5000,
            keyNum = "AA",
            id = "ewdasdasda"
        ),
        Product(
            name = "Sản phẩm 4",
            imageUrl = "https://images.pexels.com/photos/24860314/pexels-photo-24860314/free-photo-of-ly-c-c-chen-kinh.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500",
            slotNo = 1,
            stock = 5,
            quantity = 5,
            slotNumber = "AA",
            price = 5000,
            keyNum = "AA",
            id = "ewdasdasda"
        ),
        Product(
            name = "Sản phẩm 1",
            imageUrl = "https://images.pexels.com/photos/24860314/pexels-photo-24860314/free-photo-of-ly-c-c-chen-kinh.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500",
            slotNo = 1,
            stock = 5,
            quantity = 5,
            slotNumber = "AA",
            price = 5000,
            keyNum = "AA",
            id = "ewdasdasda"
        ),
        Product(
            name = "Sản phẩm 2",
            imageUrl = "https://images.pexels.com/photos/24860314/pexels-photo-24860314/free-photo-of-ly-c-c-chen-kinh.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500",
            slotNo = 1,
            stock = 5,
            quantity = 5,
            slotNumber = "AA",
            price = 5000,
            keyNum = "AA",
            id = "ewdasdasda"
        ),
        Product(
            name = "Sản phẩm 3",
            imageUrl = "https://images.pexels.com/photos/24860314/pexels-photo-24860314/free-photo-of-ly-c-c-chen-kinh.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500",
            slotNo = 1,
            stock = 5,
            quantity = 5,
            slotNumber = "AA",
            price = 5000,
            keyNum = "AA",
            id = "ewdasdasda"
        ),
        Product(
            name = "Sản phẩm 4",
            imageUrl = "https://images.pexels.com/photos/24860314/pexels-photo-24860314/free-photo-of-ly-c-c-chen-kinh.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500",
            slotNo = 1,
            stock = 5,
            quantity = 5,
            slotNumber = "AA",
            price = 5000,
            keyNum = "AA",
            id = "ewdasdasda"
        )
    )

    Scaffold(
        topBar = { TopAppBar(title = { Text("HOME") }) },
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
                    products = products,
                    isAutoScrollEnabled = true,
                    scrollIntervalMillis = 100L
                )

            }
        }
    )
}


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

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    HomeScreen()
}