package exercise_2_dont_use_else.fakes

interface InteractionRepository {

    fun findByExternalConversationId(externalConversationId: String): Interaction?
    fun updateStatus(name: String, id: String)

}

open class FakeInteractionRepository : InteractionRepository {

    private var name: String = ""
    private var id: String = ""
    override fun updateStatus(name: String, id: String) {
        this.name = name
        this.id = id
    }

    override fun findByExternalConversationId(externalConversationId: String): Interaction? {
        return Interaction(externalConversationId)
    }

    fun assertInteractionUpdated(name: String, id: String) {
        assert(name == this.name)
        assert(id == this.id)
    }
}

class FakeInteractionRepositoryWithNoInteraction : FakeInteractionRepository() {
    override fun findByExternalConversationId(externalConversationId: String): Interaction? {
        return null
    }
}