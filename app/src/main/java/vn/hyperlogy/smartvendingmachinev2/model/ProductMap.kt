package vn.hyperlogy.smartvendingmachinev2.model

data class ProductMapItem (
    var id: String,
    var slotNo: Int,
    var hexCode: String,
    var capacity: Int,
    var slotCode: String,
    var remain: Int,
    var price: Int,
    var product: ProductDetail?,
    var isError: Boolean,
    var machinePromotionId: Long = 0,
    var discountPrice: Int = 0,
    var active: Boolean = false,
    var isDouble: Boolean = false
)

data class ProductDetail(
    var id: String,
    var name: String,
    var code: String,
    var description: String,
    var standardPrice: Int,
    var type: Int,
    var active: Boolean,
    var imageDetail: String
)