package exercise_1_one_level_of_indentation.fakes

import java.util.*

interface CategoryProductRepository {
    fun findByProductId(productId: String): CategoryProduct?
    fun save(categoryProduct: CategoryProduct): CategoryProduct {
        return categoryProduct
    }
}

class FakeCategoryProductRepositoryWith(private val categoryProduct: CategoryProduct) : CategoryProductRepository {

    override fun findByProductId(productId: String): CategoryProduct? {
        return categoryProduct
    }

}

object FakeCategoryProductRepositoryWithoutProduct : CategoryProductRepository {

    override fun findByProductId(productId: String): CategoryProduct? {
        return null
    }

}