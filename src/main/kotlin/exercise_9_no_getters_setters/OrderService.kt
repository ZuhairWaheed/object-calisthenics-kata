package exercise_9_no_getters_setters

import exercise_9_no_getters_setters.fakes.Order
import exercise_9_no_getters_setters.fakes.OrderRepository
import exercise_9_no_getters_setters.fakes.OrderStatus
import java.util.function.Consumer

/*
Refactor the code below to remove the getters and setters.
 */

class OrderService(private val orderRepository: OrderRepository) {

    fun updateOrderStatus(orderNumbers: List<String>, userId: String) {
        val orders = orderRepository.findAllByOrderNumberIn(orderNumbers)
        orders.forEach(Consumer<Order> { _order: Order ->
            if (_order.status == OrderStatus.CLOSED) {
                _order.status = OrderStatus.REATTEMPT
                _order.updatedByUser = userId
            }
        })
    }
}