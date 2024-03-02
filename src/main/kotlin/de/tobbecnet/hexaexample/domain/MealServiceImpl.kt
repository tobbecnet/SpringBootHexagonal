package de.tobbecnet.hexaexample.domain

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import java.util.*


// Let's see if there will be any code here in the future or if everything is just dispatched to the mealDataAdapter...
// Todo's we will have to deal with somewhere are authZ and validation.
@Component
class MealServiceImpl(
    @Autowired val mealDataAdapter: MealDataAdapter
) : MealUseCases {


    override fun getAllMeals(): Collection<Meal> {
        return mealDataAdapter.getAllMeals()
    }

    override fun getMeal(id: UUID): Meal {
        return mealDataAdapter.getMeal(id)
    }

    override fun addMeal(meal: Meal) {
        TODO("Not yet implemented")
    }

    override fun updateMeal(meal: Meal) {
        TODO("Not yet implemented")
    }
}