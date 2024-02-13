package de.tobbecnet.hexaexample.web

import de.tobbecnet.hexaexample.domain.ImageSize
import de.tobbecnet.hexaexample.domain.ImageUseCases
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestParam
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
        "/image/{size}/{id}",
        produces = [MediaType.IMAGE_JPEG_VALUE]
    )
    @ResponseBody
    fun getImage(@PathVariable size: ImageSize, @PathVariable id: String): ByteArray {
        try {
            val uuid = UUID.fromString(id)
            return imageUseCases.getImageBlobByIdAndSize(uuid, size)
        } catch (e: Exception) {
            throw ResponseStatusException(HttpStatus.NOT_FOUND)
        }
    }
}