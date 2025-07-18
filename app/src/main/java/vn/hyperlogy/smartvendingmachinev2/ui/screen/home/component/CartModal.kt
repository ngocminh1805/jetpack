package vn.hyperlogy.smartvendingmachinev2.ui.screen.home.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties

@Composable
fun CartModal(show: Boolean) {

    val title by remember { mutableStateOf("Sản phẩm") }

    if (show) {
        Dialog(
            onDismissRequest = {},
            properties = DialogProperties(usePlatformDefaultWidth = false)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth(0.8f)
                    .fillMaxHeight(0.6f)
                    .padding(16.dp)
                    .clip(RoundedCornerShape(32.dp)),
            ) {
                Surface {
                    Column(
                        modifier = Modifier
                            .background(Color.White)
                            .fillMaxHeight()
                            .fillMaxWidth()
                    ) {
                        Text(title)
                        Column {
                            Text("OPEN MODAL")
                            Text("OPEN MODAL")
                            Row {

                            }
                        }
                    }
                }
            }
        }
    }


}

@Preview
@Composable
fun PreviewCartModal() {
    CartModal(true)
}