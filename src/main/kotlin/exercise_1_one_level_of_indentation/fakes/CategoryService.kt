package exercise_1_one_level_of_indentation.fakes

import java.util.*

interface CategoryService {
    fun getCategory(categoryId: UUID): Category {
        return Category(categoryId)
    }
}

object FakeCategoryService : CategoryService {

}