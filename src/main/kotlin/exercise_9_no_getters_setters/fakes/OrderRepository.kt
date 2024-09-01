package exercise_9_no_getters_setters.fakes

interface OrderRepository {
    fun findAllByOrderNumberIn(orderNumbers: List<String>): List<Order> {
        return listOf(
            Order("", OrderStatus.OPEN, ""),
            Order("", OrderStatus.CLOSED, "")
        )
    }

}
