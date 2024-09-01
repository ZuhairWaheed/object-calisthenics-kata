package exercise_3_wrap_primitives_and_strings

import exercise_3_wrap_primitives_and_strings.fakes.*
import java.time.LocalDateTime

/*
Identify the domain entity represented as a string primitive.
Wrap it in a class and move related behaviours there.
 */

class PlanService(private val planRepository: PlanRepository) {

    fun createPlan(planCreationDto: PlanCreationDto) {

        var tourNumber: String = planRepository
            .getPreviousTourNumber(planCreationDto.warehouseId)

        var lastDigitsOfPreviousTourNumber: Int = tourNumber
            .split("-").last().toInt()

        val plan: Plan = planCreationDto.toPlanModel()
        val planTours: MutableList<PlanTour> = mutableListOf()

        planCreationDto.tours.forEach {
            tourNumber = createTourNumber(planCreationDto.warehouseId, lastDigitsOfPreviousTourNumber)
            planTours.add(PlanTour(tourNumber, it.tourName))
            lastDigitsOfPreviousTourNumber = tourNumber.split("-").last().toInt()
        }

        plan.planTours = planTours
        planRepository.save(plan)
    }

    private fun createTourNumber(warehouseId: String, lastDigitsOfPreviousTourNumber: Int): String {
        val random1DigitNum = Utils.randomNumbers(1)
        val localDateTimeNow = LocalDateTime.now()
        val lastTwoDigitsOfYear = localDateTimeNow.year % 100
        val uniqueDigits = String.format("%04d", lastDigitsOfPreviousTourNumber + random1DigitNum.toInt() + 1)
        val dayOfYear: String = String.format("%03d", localDateTimeNow.dayOfYear)

        return "$warehouseId-$lastTwoDigitsOfYear-$dayOfYear-$uniqueDigits"
    }
}