package exercise_2_dont_use_else

import exercise_2_dont_use_else.fakes.FailedToFetchInteraction
import exercise_2_dont_use_else.fakes.InteractionRepository
import exercise_2_dont_use_else.fakes.InteractionStatus
import java.util.logging.Logger

/*
Refactor the code below to remove the else block.
 */

class InteractionService(private val interactionRepository: InteractionRepository) {

    fun updateInteractionStatus(externalConversationId: String, status: InteractionStatus) {
        val interaction = interactionRepository.findByExternalConversationId(externalConversationId)
        if (interaction != null) {
            interactionRepository.updateStatus(status.name, interaction.id)
        } else {
            val message = "Interaction id $externalConversationId not found!"
            throw FailedToFetchInteraction(message)
        }
    }
}