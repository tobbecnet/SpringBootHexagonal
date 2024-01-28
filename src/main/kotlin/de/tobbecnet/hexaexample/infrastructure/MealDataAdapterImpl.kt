package de.tobbecnet.hexaexample.infrastructure

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
    override fun getAllMeals(): List<Meal> {
        return mealRepository.findAll()
            .map {
                Meal(
                    title = it.title,
                    description = "",   // TODO
                    introText = it.introText,
                    ingredients = HashMap(),    // TODO
                    imageAsBase64Data = ""      // TODO
                )
            }
    }


}