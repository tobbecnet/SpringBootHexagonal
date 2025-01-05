package de.tobbecnet.hexaexample.api.model.response

import de.tobbecnet.hexaexample.domain.Meal
import jakarta.validation.constraints.Size
import java.util.*


data class MealResponse(
    val id: UUID,
    @Size(min = 5, max = 1024) var title: String,
    var introText: String?,
    var ingredients: List<Ingredient>,
    var description: String,
    var mealSteps: List<MealStep>,
    var photoCameraMotives: List<PhotoMotiveMetadata>
) {

    companion object {
        fun of(model: Meal) {
            MealResponse(
                id = model.id,
                title = model.title,
                introText = model.introText,
                ingredients = model.ingredients.map {
                    Ingredient(
                        quantity = it.quantity,
                        unit = it.unit,
                        ingredient = it.ingredient,
                        additionalDescription = it.additionalDescription
                    )
                },
                description = model.description,
                mealSteps = model.mealSteps.map {
                    MealStep(
                        id = it.id,
                        stepDescription = it.stepDescription
                    )
                },
                photoCameraMotives = model.photoCameraMotives.map {
                    PhotoMotiveMetadata(
                        id = it.id,
                        type = it.type
                    )
                }
            )
        }
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


data class PhotoMotiveMetadata(
    val id: UUID,
    val type: String
)