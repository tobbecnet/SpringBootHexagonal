package de.tobbecnet.hexaexample.web

import de.tobbecnet.hexaexample.domain.ImageUseCases
import de.tobbecnet.hexaexample.domain.MealStepMotiveSize
import de.tobbecnet.hexaexample.domain.PhotoMotiveSize
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.server.ResponseStatusException
import java.util.*


/**
 * Get images
 */
@Controller
class ImageController(
    val imageUseCases: ImageUseCases
) {
    @GetMapping(
        "/photoMotive/{size}/{id}",
        produces = [MediaType.IMAGE_JPEG_VALUE]
    )
    @ResponseBody           // TODO Maybe this is a RestController?
    fun getPhotoMotive(@PathVariable size: PhotoMotiveSize, @PathVariable id: String): ByteArray {
        try {
            val uuid = UUID.fromString(id)
            return imageUseCases.getPhotoMotiveBlobByMotiveIdAndSize(uuid, size)
        } catch (e: Exception) {
            throw ResponseStatusException(HttpStatus.NOT_FOUND)
        }
    }

    @GetMapping(
        "/mealHeroImage/{mealId}",
        produces = [MediaType.IMAGE_JPEG_VALUE]
    )
    @ResponseBody           // TODO Maybe this is a RestController?
    fun getMealHeroImage(@PathVariable mealId: String): ByteArray {
        try {
            val uuid = UUID.fromString(mealId)
            return imageUseCases.getMealHeroImageBlobByMealId(uuid)
        } catch (e: Exception) {
            throw ResponseStatusException(HttpStatus.NOT_FOUND)
        }
    }

    @GetMapping(
        "/mealStepMotive/{size}/{mealStepId}",
        produces = [MediaType.IMAGE_JPEG_VALUE]
    )
    @ResponseBody           // TODO Maybe this is a RestController?
    fun getMealStepMotive(@PathVariable size: MealStepMotiveSize, @PathVariable mealStepId: String): ByteArray {
        try {
            val uuid = UUID.fromString(mealStepId)
            return imageUseCases.getMealStepImageBlobByMealStepIdAndSize(uuid, size)
        } catch (e: Exception) {
            throw ResponseStatusException(HttpStatus.NOT_FOUND)
        }
    }
}