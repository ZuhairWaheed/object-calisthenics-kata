package exercise_4_first_class_collections.fakes

interface PaymentBreakdownRepository {
    fun findBy(paymentId: String): List<PaymentBreakdown> {
        return listOf(
            PaymentBreakdown(PaymentMode.WALLET, TransactionStatus.SUCCESS, 0.0),
            PaymentBreakdown(PaymentMode.CASH, TransactionStatus.SUCCESS, 0.0)
        )
    }

}
