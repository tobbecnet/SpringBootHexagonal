package de.tobbecnet.hexaexample.domain

import org.springframework.stereotype.Component


@Component
class MealServiceImpl : MealUseCases {

    private val testMealList = listOf(
        Meal(title = "Nasi Goreng",
            introText = "A classic dish. Add in any chopped veggies or some tofu.",
            ingredients = mapOf(),
            description = "",
            imageAsBase64Data = ""
        ),
        Meal(title = "Gado Gado",
            introText = "Beautifully sweet. Vegetables made with peanut sauce - an all time classic dish.",
            ingredients = mapOf(),
            description = "",
            imageAsBase64Data = ""
        ),
        Meal(title = "Risotto",
            introText = "When rice meets vegetables and flavors.",
            ingredients = mapOf(),
            description = "",
            imageAsBase64Data = ""
        ));

    override fun getAllMeals(): Collection<Meal> {
        return testMealList
    }

    override fun addMeal(meal: Meal) {
        TODO("Not yet implemented")
    }

    override fun updateMeal(meal: Meal) {
        TODO("Not yet implemented")
    }
}