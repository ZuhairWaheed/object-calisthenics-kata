package exercise_7_keep_all_entities_small.fakes

data class OrderDetail(
    val campaignCycleId: String,
    val orderNumber: String,
    val status: OrderStatus)