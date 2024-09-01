package exercise_4_first_class_collections.fakes

interface PaymentRepository {
    fun findBy(referenceId: String): Payment {
        return Payment("id", "referenceId", 0.0)
    }

}
