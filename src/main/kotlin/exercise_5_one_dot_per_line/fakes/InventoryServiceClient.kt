package exercise_5_one_dot_per_line.fakes

interface InventoryServiceClient {
    fun getWarehouse(headers: Map<String, String>, zoneId: String): IdValuePairDto = IdValuePairDto()
}
