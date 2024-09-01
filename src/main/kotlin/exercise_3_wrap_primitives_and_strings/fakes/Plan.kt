package exercise_3_wrap_primitives_and_strings.fakes

import java.sql.Timestamp

data class Plan(
    var warehouseId: String = "",
    val createdAt: Timestamp = Timestamp.valueOf("1970-01-01 05:01:01"),
    var planTours: MutableList<PlanTour> = mutableListOf()
)




