package de.tobbecnet.hexaexample.infrastructure

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import de.tobbecnet.hexaexample.domain.*
import de.tobbecnet.hexaexample.infrastructure.repository.MealRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import java.util.*


// Main purpose of this adapter implementation is mapping db entities to domain objects.
@Component
class MealDataAdapterImpl(
    @Autowired val mealRepository: MealRepository
) : MealDataAdapter {

    val mapper = jacksonObjectMapper()

    override fun getAllMeals(): List<Meal> {
        return mealRepository.findAll()
            .map { entityToDomain(it) }
    }

    override fun getMeal(id: UUID): Meal {
        return mealRepository.findById(id)
            .orElseThrow()
            .let { entityToDomain(it) }
    }

    private fun entityToDomain(meal: MealEntity): Meal {
        return Meal(
            id = meal.id,
            title = meal.title,
            introText = meal.introText,
            ingredients = mapper.readValue<List<Ingredient>>(meal.ingredientsAsJson),
            description = meal.description,
            mealSteps = meal.mealSteps.map { mealStep ->
                MealStep(mealStep.id, mealStep.stepDescription)
            },
            photoCameraMotives = meal.photoMotiveCollection.map { motive ->
                PhotoMotiveMetadata(
                    motive.id,
                    motive.type
                )
            }
        )
    }
}