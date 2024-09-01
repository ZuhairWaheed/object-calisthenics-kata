package exercise_6_dont_abbreviate.fakes

data class CoordinateDto(
    val latitude: Double,
    val longitude: Double,
    val provider: String = "fused",
    val accuracy: Double = 0.0
)
