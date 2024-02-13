package de.tobbecnet.hexaexample.domain

import de.tobbecnet.hexaexample.infrastructure.PhotoCameraMotiveEntity
import java.util.UUID

interface ImageDataAdapter {

    fun getImageBlobByIdAndSize(id: UUID, size: ImageSize): ByteArray

}