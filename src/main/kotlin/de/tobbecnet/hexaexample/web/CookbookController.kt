package de.tobbecnet.hexaexample.web

import de.tobbecnet.hexaexample.domain.MealUseCases
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.ui.set
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.servlet.ModelAndView


/**
 * TODO https://spring.io/guides/tutorials/spring-boot-kotlin/
 * Main controller for the cookbook page.
 */
@Controller
class CookbookController(
    @Autowired val mealUseCases: MealUseCases
) {

    // TODO i18n?

    @GetMapping("/")
    fun Index(model: Model): String {
        model.addAttribute("title", "The Eurasian vegetarian")
        model["subtitle"] = "Modern vegetarian recipes for a unique world."
        model["meals"] = mealUseCases.getAllMeals()
        return "index"
    }
}