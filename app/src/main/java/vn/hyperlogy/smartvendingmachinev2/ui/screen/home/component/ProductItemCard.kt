package vn.hyperlogy.smartvendingmachinev2.ui.screen.home.component

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import vn.hyperlogy.smartvendingmachinev2.model.Product
import vn.hyperlogy.smartvendingmachinev2.model.ProductMapItem

@SuppressLint("UnusedBoxWithConstraintsScope")
@Composable
fun ProductCard(product: ProductMapItem, modifier: Modifier = Modifier) {

    BoxWithConstraints(modifier = modifier) {
        val imageHeight = maxHeight * 2 / 3
        val imageWidth = maxWidth * 2 / 3

        Column(
            modifier = modifier
                .background(Color(0xFFF5F5F5), shape = RoundedCornerShape(12.dp))
                .padding(12.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {;
            AsyncImage(
                model = "https://app.smartvendingmachines.net/files/image/" + product.product?.imageDetail,
                contentDescription = product.product?.name,
                contentScale = ContentScale.Inside,
                modifier = Modifier
                    .height(imageHeight)
                    .width(imageWidth)
                    .fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(8.dp))
            Row(modifier = Modifier.fillMaxWidth()) {
                Row(modifier = Modifier.weight(1f)) {
                    Text(
                           text = "Price: ",
                        style = MaterialTheme.typography.titleSmall,
                        color = Color.Black
                    )
                }
            }
            Text(
                text = product.product?.name ?: "",
                style = MaterialTheme.typography.titleSmall,
                color = Color.Black
            )
        }

    }
}

//@Preview(showBackground = true)
//@Composable
//fun ProductItemPreview() {
//
//}