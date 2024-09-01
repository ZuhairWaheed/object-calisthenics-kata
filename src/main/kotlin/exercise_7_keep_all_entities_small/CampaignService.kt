package exercise_7_keep_all_entities_small

import exercise_7_keep_all_entities_small.fakes.*
import java.util.function.Function
import java.util.stream.Collectors

/*
Refactor this large method till it has 5 statements or fewer.
 */

class CampaignService(
    private val orderDetailRepository: OrderDetailRepository,
    private val customerCampaignCycleRepository: CustomerCampaignCycleRepository
) {

    fun getOrderStatusByOrderNumber(userId: String?, orderNumber: String): String {

        var status: String = ""

        val orders: List<OrderDetail> = orderDetailRepository.findByOrderNumber(orderNumber)

        val customerCampaignCycles: Map<String, CustomerCampaignCycle> =
            customerCampaignCycleRepository.findByIdIn(
                orders.stream().map(OrderDetail::campaignCycleId)
                    .collect(Collectors.toList()))
            .stream().collect(Collectors.toMap(CustomerCampaignCycle::id, Function.identity()))

        for (order in orders) {
            val customerCampaignCycle: CustomerCampaignCycle = customerCampaignCycles[order.campaignCycleId]!!
            val campaignStatus: CustomerCampaignStatus = customerCampaignCycle.customerCampaignCycleStatus
            if (campaignStatus != CustomerCampaignStatus.COMPLETED
                || (campaignStatus == CustomerCampaignStatus.COMPLETED
                        && order.status != OrderStatus.OPEN)
            ) {
                status = order.status.name
                break
            }
        }
        return status
    }
}