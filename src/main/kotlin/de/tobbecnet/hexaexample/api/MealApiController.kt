package de.tobbecnet.hexaexample.api

import de.tobbecnet.hexaexample.domain.Meal
import de.tobbecnet.hexaexample.domain.MealUseCases
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.dao.DataAccessException
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageImpl
import org.springframework.data.domain.PageRequest
import org.springframework.http.HttpStatus
import org.springframework.http.ProblemDetail
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException
import org.springframework.web.server.ResponseStatusException
import java.util.NoSuchElementException
import java.util.UUID
import kotlin.math.min


@RestController
@RequestMapping("api/meal")
class MealApiController(
    @Autowired val mealUseCases: MealUseCases
) {


    @GetMapping("")
    fun getPage(
        @RequestParam(defaultValue = "0") page: Int,
        @RequestParam(defaultValue = "10") size: Int
    ): Page<Meal> {

        if(page < 0 || size < 1) {
            throw ResponseStatusException(HttpStatus.BAD_REQUEST, "Incoming paging parameters not reasonable.")
        }

        val meals = mealUseCases.getAllMeals().toList()

        val totalSize = meals.size
        val startIndex = page * size
        val endIndex = min(startIndex + size, totalSize)

        if(startIndex >= endIndex) {
            return PageImpl(listOf(), PageRequest.of(page, size), totalSize.toLong())
        }

        val mealsSubList = meals.subList(startIndex, endIndex)
        val page = PageImpl(mealsSubList, PageRequest.of(page, size), totalSize.toLong())

        return page
    }

    @GetMapping("/{id}")
    fun getOne(@PathVariable id: UUID): Meal {
        try {
            return mealUseCases.getMeal(id)
        } catch (e: NoSuchElementException) {
            throw ResponseStatusException(HttpStatus.NOT_FOUND, "Element not found.", e)
        } catch (e: DataAccessException) {
            throw ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Database error.", e)
        } catch (e: Exception) {
            throw ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Internal error.", e)
        }

    }

    // Cannot parse id param to UUID
    @ExceptionHandler(MethodArgumentTypeMismatchException::class)
    @ResponseBody
    fun handle(e: MethodArgumentTypeMismatchException): ResponseEntity<ProblemDetail> =
        ResponseEntity
            .status(500)
            .body(
                ProblemDetail.forStatusAndDetail(
                    HttpStatus.INTERNAL_SERVER_ERROR,
                    "Cannot parse incoming parameter(s)."
                )
            )
}