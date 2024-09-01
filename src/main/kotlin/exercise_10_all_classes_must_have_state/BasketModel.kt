package exercise_10_all_classes_must_have_state

data class BasketModel(
    var actualPrice: Double,
    var discountedPrice: Double,
    var quantity: Int = 0,
    var promoDiscount: Double = 0.0
)