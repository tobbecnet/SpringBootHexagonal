package de.tobbecnet.hexaexample.api.model.request

import de.tobbecnet.hexaexample.domain.Meal
import jakarta.validation.constraints.Size
import java.util.*


data class CreateMealCommand (
    @Size(min = 5, max = 1024) var title: String,
    var introText: String?,
    var ingredients: List<Ingredient>?,
    var description: String,
    var mealSteps: List<MealStep>,
) {

    fun mapToDomain(): Meal {
        return Meal(
            id = UUID.randomUUID(),
            title = this.title,
            introText = this.introText,
            ingredients = this.ingredients?.map {
                de.tobbecnet.hexaexample.domain.Ingredient(
                    quantity = it.quantity,
                    unit = it.unit,
                    ingredient = it.ingredient,
                    additionalDescription = it.additionalDescription
                )
            } ?: listOf(),
            description = this.description,
            mealSteps = this.mealSteps.map {
                de.tobbecnet.hexaexample.domain.MealStep(
                    id = UUID.randomUUID(),
                    stepDescription = it.stepDescription
                )
            },
            photoCameraMotives = listOf()
        )
    }
}


data class Ingredient(
    val quantity: String,
    val unit: String?,
    val ingredient: String,
    val additionalDescription: String?
)


data class MealStep(
    val id: UUID,
    val stepDescription: String
)