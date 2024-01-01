package de.tobbecnet.hexaexample.domain

import org.springframework.stereotype.Component


@Component
class MealServiceImpl : MealUseCases {

    override fun getAllMeals(): Collection<Meal> {
        var testMeals = listOf(
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
            ),
        )

        return testMeals
    }

}