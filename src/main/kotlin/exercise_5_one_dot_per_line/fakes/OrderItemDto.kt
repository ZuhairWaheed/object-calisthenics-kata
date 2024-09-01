package exercise_5_one_dot_per_line.fakes

class OrderItemDto (
    var id: String,
    var variantId: String,
    var visibilityWarehouseId: String = "",
    var brandId: String,
    var categoryId: String,

    var promoId: String,


    var name: String,
    var quantity: Int,

    var originalPrice: Double = 0.0,

    var unitPrice: Double,
)