package exercise_5_one_dot_per_line

import exercise_5_one_dot_per_line.fakes.IdValuePairDto
import exercise_5_one_dot_per_line.fakes.InventoryServiceClient
import exercise_5_one_dot_per_line.fakes.OrderCreateDtoV2
import exercise_5_one_dot_per_line.fakes.TokenDetailsDto
import org.apache.commons.lang3.StringUtils
import java.util.*

/*
Identify where the internal details of neighbouring classes are accessed.
Refactor to hide those details from this class.
 */

class OrderService(private val inventoryServiceClient: InventoryServiceClient) {

    fun getWarehouseIdValuePairDto(
        orderDetails: OrderCreateDtoV2,
        tokenDetails: TokenDetailsDto
    ): IdValuePairDto {

        var warehouse = IdValuePairDto("", "")
        if (StringUtils.isNotEmpty(orderDetails.items.get(0).visibilityWarehouseId)) {
            return IdValuePairDto(
                orderDetails.items.get(0).visibilityWarehouseId,
                orderDetails.items.get(0).visibilityWarehouseId
            )
        }
        if (!orderDetails.customer.zoneInfo.ucId.isEmpty())
            warehouse = inventoryServiceClient.getWarehouse(
                tokenDetails.toHeaderMap(),
                Optional.ofNullable(orderDetails.customer.zoneInfo.ucId).orElse("")
            )
        return warehouse
    }
}