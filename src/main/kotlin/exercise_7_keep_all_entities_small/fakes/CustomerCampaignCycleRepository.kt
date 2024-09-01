package exercise_7_keep_all_entities_small.fakes

interface CustomerCampaignCycleRepository {
    fun findByIdIn(campaignCycleIds: List<String>): List<CustomerCampaignCycle> {
        return emptyList()
    }

}
