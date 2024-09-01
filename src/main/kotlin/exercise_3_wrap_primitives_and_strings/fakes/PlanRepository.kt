package exercise_3_wrap_primitives_and_strings.fakes

interface PlanRepository {
    fun getTodaysWarehousePlans(warehouseId: String): List<Plan> = emptyList()
    fun save(plan: Plan) {}
    fun getPreviousTourNumber(warehouseId: String): String = "K-001-21-064-4275"

}
