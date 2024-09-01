package exercise_10_all_classes_must_have_state

/*
Identify classes that have behaviour but not state and vice versa.
Refactor such that all classes have both state and behaviour.
 */

class OrderViewModel {

    fun getTotalPrice(products: List<BasketModel>): Double {
        var totalPrice = 0.0

        for (product in products) {
            val price = CalculateProductPriceUseCase.calculateProductPrice(
                product.promoDiscount,
                product.actualPrice,
                product.discountedPrice,
                product.quantity
            )
            totalPrice = totalPrice.plus(price)
        }
        return totalPrice
    }
}