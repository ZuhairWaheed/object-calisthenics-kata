package exercise_1_one_level_of_indentation

import exercise_1_one_level_of_indentation.fakes.CategoryProduct
import exercise_1_one_level_of_indentation.fakes.CategoryProductRepository
import exercise_1_one_level_of_indentation.fakes.CategoryService
import java.util.*

/*
The method below has two levels of indentation.
Refactor it to have only one level of indentation.
 */

class CatalogService(
    private val categoryProductRepository: CategoryProductRepository,
    private val categoryService: CategoryService
) {

    fun updateCategoryProductMapping(newCategoryId: UUID, productId: String): CategoryProduct {
        var categoryProduct = categoryProductRepository.findByProductId(productId)

        if (categoryProduct != null) {
            // <- level one
            if (newCategoryId != categoryProduct.getCategoryId()) {
                // <- level two
                categoryProduct = CategoryProduct.Builder(categoryProduct)
                    .withCategory(categoryService.getCategory(newCategoryId))
                    .build()
            }
        } else {
            categoryProduct = CategoryProduct.Builder(categoryService.getCategory(newCategoryId))
                .withProductId(productId)
                .build()
        }

        return categoryProductRepository.save(categoryProduct)
    }

}