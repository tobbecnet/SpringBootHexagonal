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
import org.springframework.web.bind.annotation.*
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException
import org.springframework.web.server.ResponseStatusException
import java.util.NoSuchElementException
import java.util.UUID
import kotlin.math.min


data class PostResult(val message:String)


@RestController
@RequestMapping("api/meal")
class MealApiController(
    @Autowired val mealUseCases: MealUseCases
) {


    @GetMapping("/**")
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
        val pageContent = PageImpl(mealsSubList, PageRequest.of(page, size), totalSize.toLong())

        return pageContent
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

    @PostMapping("/**")
    fun postOne(@RequestBody meal: Meal): ResponseEntity<PostResult> {
        return ResponseEntity.status(HttpStatus.CREATED).body(PostResult("We got a message."));
    }

    // Cannot parse id param to UUID
    @ExceptionHandler(MethodArgumentTypeMismatchException::class)
    @ResponseBody
    fun handle(e: MethodArgumentTypeMismatchException): ResponseEntity<ProblemDetail> =
        ResponseEntity
            .status(HttpStatus.INTERNAL_SERVER_ERROR)
            .body(
                ProblemDetail.forStatusAndDetail(
                    HttpStatus.INTERNAL_SERVER_ERROR,
                    "Cannot parse incoming parameter(s)."
                )
            )
}