package exercise_1_one_level_of_indentation.fakes

import java.util.*

data class CategoryProduct(var category: Category, val productId: String) {

    fun getCategoryId(): UUID {
        return category.id
    }

    class Builder {
        private var productId: String = ""
        private var category: Category

        constructor(category: Category) {
            this.category = category
        }
        constructor(model: CategoryProduct) {
            this.category = model.category
            this.productId = model.productId
        }

        fun withCategory(category: Category): Builder {
            this.category = category
            return this
        }

        fun withProductId(productId: String): Builder {
            this.productId = productId
            return this
        }

        fun build(): CategoryProduct {
            return CategoryProduct(category, productId)
        }
    }
}