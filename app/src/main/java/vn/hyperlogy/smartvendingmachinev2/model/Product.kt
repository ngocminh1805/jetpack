package vn.hyperlogy.smartvendingmachinev2.model

data class Product(
    val id: String,
    val slotNo: Int,
    val keyNum: String,
    val quantity: Int,
    val stock: Int,
    val price: Int,
    val name: String,
    val imageUrl: String,
    val slotNumber: String ,
    val disable: Boolean = false,
)
