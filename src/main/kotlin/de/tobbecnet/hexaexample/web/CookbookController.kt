package de.tobbecnet.hexaexample.web

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
class CookbookController {

    // TODO i18n

    @GetMapping("/")
    fun Index(model: Model): String {
        model.addAttribute("title", "Cookbook")
        model["subtitle"] = "Modern recipes for a better world."

        return "index"
    }
}