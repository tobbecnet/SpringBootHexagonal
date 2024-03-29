package de.tobbecnet.hexaexample.web

import de.tobbecnet.hexaexample.domain.MealUseCases
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.ui.set
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import java.util.UUID


// We start using a simple MVC approach. Example: https://www.baeldung.com/spring-boot-mustache
// TODO https://reflectoring.io/spring-hexagonal/
/**
 *
 */
@Controller
class MealController(
    @Autowired val mealUseCases: MealUseCases
) {

    @GetMapping("/meal/{id}")
    fun Meal(model: Model, @PathVariable id: UUID): String {

        val meal = mealUseCases.getMeal(id)

        model.addAttribute("title", "The Eurasian vegetarian")

        model["mealId"] = meal.id
        model["mealTitle"] = meal.title
        model["introText"] = meal.introText
        model["ingredients"] = meal.ingredients
        model["description"] = meal.description
        model["steps"] = meal.mealSteps.value

        return "meal"
    }
}