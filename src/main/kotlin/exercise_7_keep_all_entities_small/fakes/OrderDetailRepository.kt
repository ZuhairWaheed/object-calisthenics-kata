package exercise_7_keep_all_entities_small.fakes

interface OrderDetailRepository {
    fun findByOrderNumber(orderNumber: String): List<OrderDetail> {
        return emptyList()
    }

}
