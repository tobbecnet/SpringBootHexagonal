package de.tobbecnet.hexaexample.domain

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import java.util.*


enum class ImageSize {
    small, medium, large
}

@Component
class ImageServiceImpl(
    @Autowired val imageDataAdapter: ImageDataAdapter
) : ImageUseCases {


    override fun getImageBlobByIdAndSize(id: UUID, size: ImageSize): ByteArray {
        return imageDataAdapter.getImageBlobByIdAndSize(id, size)
    }
}