package exercise_3_wrap_primitives_and_strings.fakes

data class PlanCreationDto(
        val warehouseId: String,
        val tours: List<PlanTourDto>
) {

    fun toPlanModel(): Plan {
        return Plan(warehouseId)
    }

    data class PlanTourDto(val tourName: String)
}