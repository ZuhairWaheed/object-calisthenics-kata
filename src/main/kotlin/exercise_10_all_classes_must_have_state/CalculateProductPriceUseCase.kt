package exercise_10_all_classes_must_have_state

class CalculateProductPriceUseCase {
    companion object {
        fun calculateProductPrice(
            promoDiscount: Double,
            actualPrice: Double,
            discountedPrice: Double,
            quantity: Int
        ): Double {
            val discountApplicable = if (promoDiscount > 0)
                (actualPrice - promoDiscount)
            else discountedPrice

            return if (discountApplicable > 0)
                discountApplicable * quantity
            else
                actualPrice * quantity
        }
    }
}
