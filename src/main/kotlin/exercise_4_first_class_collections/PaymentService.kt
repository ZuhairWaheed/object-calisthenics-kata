package exercise_4_first_class_collections

import exercise_4_first_class_collections.fakes.*
import java.util.*

/*
Wrap the collection into a class.
Move operations performed on that collection into the class.
 */

class PaymentService(
    private val paymentRepository: PaymentRepository,
    private val paymentBreakdownRepository: PaymentBreakdownRepository
) {

    fun getTransactionStatusForWallet(referenceId: String): TransactionStatus {
        val payment: Payment = paymentRepository.findBy(referenceId)

        val paymentBreakdowns: List<PaymentBreakdown> =
            paymentBreakdownRepository.findBy(payment.id)

        val paymentBreakdownForWallet: Optional<PaymentBreakdown> = paymentBreakdowns
            .stream()
            .filter { paymentBreakdown: PaymentBreakdown ->
                paymentBreakdown.paymentMode == PaymentMode.WALLET
            }
            .findFirst()

        return paymentBreakdownForWallet
            .orElseThrow{ PaymentBreakdownForWalletNotFound() }
            .transactionStatus
    }
}