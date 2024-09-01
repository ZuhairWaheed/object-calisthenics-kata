package exercise_2_dont_use_else.fakes

data class Interaction(
    var id: String,
    var status: InteractionStatus = InteractionStatus.ACTIVE
)