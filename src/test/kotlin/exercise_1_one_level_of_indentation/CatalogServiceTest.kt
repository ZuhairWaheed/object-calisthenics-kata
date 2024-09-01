package exercise_1_one_level_of_indentation

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import exercise_1_one_level_of_indentation.fakes.*
import java.util.*

class CatalogServiceTest {

    @Test
    fun `update with same category ID`() {
        val expectedCategoryProduct = CategoryProduct(Category(UUID.randomUUID()), "1")
        val actualCategoryProduct = CatalogService(
            FakeCategoryProductRepositoryWith(expectedCategoryProduct), FakeCategoryService)
            .updateCategoryProductMapping(
                expectedCategoryProduct.getCategoryId(),
                "1")

        assertEquals(expectedCategoryProduct, actualCategoryProduct)
    }

    @Test
    fun `update with new category ID`() {
        val actualCategoryProduct = CatalogService(
            FakeCategoryProductRepositoryWith(CategoryProduct(Category(UUID.fromString("0000-00-00-00-000000")), "1")), FakeCategoryService)
            .updateCategoryProductMapping(
                UUID.fromString("1111-11-11-11-111111"),
                "1")

        assertEquals(
            CategoryProduct(Category(UUID.fromString("1111-11-11-11-111111")), "1"),
            actualCategoryProduct)
    }

    @Test
    fun `update where old mapping does not exist`() {
        val actualCategoryProduct = CatalogService(
            FakeCategoryProductRepositoryWithoutProduct, FakeCategoryService)
            .updateCategoryProductMapping(
                UUID.fromString("1111-11-11-11-111111"),
                "1")

        assertEquals(
            CategoryProduct(Category(UUID.fromString("1111-11-11-11-111111")), "1"),
            actualCategoryProduct)
    }
}