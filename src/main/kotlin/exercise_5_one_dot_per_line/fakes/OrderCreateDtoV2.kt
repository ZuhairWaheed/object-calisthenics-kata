package exercise_5_one_dot_per_line.fakes

import java.time.LocalDateTime

class OrderCreateDtoV2 (
    var items: List<OrderItemDto>,
    var expectedDeliveryDate: LocalDateTime,
    var channel: String,
    var userId: String,
    val deviceId: String,
    var walletAmount: Double = 0.0,
    var creditAmount: Double = 0.0,
    var planId: String = "",
    var applyServiceCharges: Boolean = false,
    var orderType: String,
    var orderStatus: String,
    var deliveryType: String,
    var inventoryType: String,
    var vehicleProvider: String,
    var planDays: Int,
    var paymentType: String,
    var creditType: String,
    val customer: OrderCustomerDtoV2
)