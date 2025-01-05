package de.tobbecnet.hexaexample.domain

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional
import java.util.*


// TODO Validation and AuthZ
@Component
class MealServiceImpl(
    @Autowired val mealDataAdapter: MealDataAdapter
) : MealUseCases {

    @Transactional(readOnly = true)
    override fun getAllMeals(): Collection<Meal> {
        return mealDataAdapter.getAllMeals()
    }

    @Transactional(readOnly = true)
    override fun getMeal(id: UUID): Meal {
        return mealDataAdapter.getMeal(id)
    }

    @Transactional
    override fun addMeal(meal: Meal) {
        TODO("Not yet implemented")
    }

    @Transactional
    override fun updateMeal(meal: Meal) {
        TODO("Not yet implemented")
    }
}