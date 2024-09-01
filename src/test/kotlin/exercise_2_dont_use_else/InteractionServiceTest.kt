package exercise_2_dont_use_else

import exercise_2_dont_use_else.fakes.FailedToFetchInteraction
import exercise_2_dont_use_else.fakes.FakeInteractionRepository
import exercise_2_dont_use_else.fakes.FakeInteractionRepositoryWithNoInteraction
import exercise_2_dont_use_else.fakes.InteractionStatus
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class InteractionServiceTest {

    @Test
    fun `update status when interaction is found`() {
        val interactionRepository = FakeInteractionRepository()
        val interactionService = InteractionService(interactionRepository)
        interactionService.updateInteractionStatus("123", InteractionStatus.OPEN)
        interactionRepository.assertInteractionUpdated("OPEN", "123")
    }

    @Test
    fun `error out when interaction not found`() {
        val interactionService = InteractionService(FakeInteractionRepositoryWithNoInteraction())
        assertThrows(FailedToFetchInteraction::class.java) {
            interactionService.updateInteractionStatus("123", InteractionStatus.OPEN)
        }
    }
}