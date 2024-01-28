package de.tobbecnet.hexaexample.infrastructure

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.jacksonMapperBuilder
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import de.tobbecnet.hexaexample.domain.Ingredient
import de.tobbecnet.hexaexample.domain.Meal
import de.tobbecnet.hexaexample.domain.MealDataAdapter
import de.tobbecnet.hexaexample.infrastructure.repository.MealRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component


// Main purpose of this adapter implementation is mapping db entities to domain objects.
@Component
class MealDataAdapterImpl(
    @Autowired val mealRepository: MealRepository
) : MealDataAdapter {

    val mapper = jacksonObjectMapper()

    override fun getAllMeals(): List<Meal> {
        return mealRepository.findAll()
            .map {
                Meal(
                    title = it.title,
                    description = it.description,
                    introText = it.introText,
                    ingredients = mapper.readValue<List<Ingredient>>(it.ingredientsAsJson),
                    imageAsBase64Data = ""      // TODO
                )
            }
    }


}