package de.tobbecnet.hexaexample.infrastructure

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.jacksonMapperBuilder
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import de.tobbecnet.hexaexample.domain.*
import de.tobbecnet.hexaexample.infrastructure.repository.ImageRepository
import de.tobbecnet.hexaexample.infrastructure.repository.MealRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import java.util.UUID


// Main purpose of this adapter implementation is mapping db entities to domain objects.
@Component
class ImageDataAdapterImpl(
    @Autowired val imageRepository: ImageRepository
) : ImageDataAdapter {

    val mapper = jacksonObjectMapper()

    override fun getImageBlobByIdAndSize(id: UUID, size: ImageSize): ByteArray {
        return imageRepository
            .findById(id)
            .orElseThrow()
            .let { entity ->
                when(size) {
                    ImageSize.small -> entity.jpgSmall
                    ImageSize.medium -> entity.jpgMedium
                    ImageSize.large -> entity.jpgLarge
                }
            } ?: throw IllegalArgumentException("No image found for id $id, size $size")
    }
}