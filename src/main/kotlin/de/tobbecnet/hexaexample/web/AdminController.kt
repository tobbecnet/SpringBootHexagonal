package de.tobbecnet.hexaexample.web

import de.tobbecnet.hexaexample.domain.MealUseCases
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.ui.set
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.servlet.ModelAndView


/**
 * https://spring.io/guides/tutorials/react-and-spring-data-rest
 * Controller leading to admin.mustache - initialize React SPA
 */
@Controller
class AdminController() {

    @GetMapping("/admin")
    fun Admin(model: Model): String {
        return "admin"
    }
}