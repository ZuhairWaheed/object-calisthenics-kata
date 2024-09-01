package exercise_4_first_class_collections.fakes


data class PaymentBreakdown(
    val paymentMode: PaymentMode,
    var transactionStatus: TransactionStatus,
    val amount: Double)