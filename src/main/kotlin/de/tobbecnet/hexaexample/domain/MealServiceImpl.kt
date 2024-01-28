package de.tobbecnet.hexaexample.domain

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component


@Component
class MealServiceImpl(
    @Autowired val mealDataAdapter: MealDataAdapter
) : MealUseCases {


    override fun getAllMeals(): Collection<Meal> {
        return mealDataAdapter.getAllMeals()
    }

    override fun addMeal(meal: Meal) {
        TODO("Not yet implemented")
    }

    override fun updateMeal(meal: Meal) {
        TODO("Not yet implemented")
    }
}