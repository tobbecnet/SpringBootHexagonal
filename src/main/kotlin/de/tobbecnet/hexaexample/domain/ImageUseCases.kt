package de.tobbecnet.hexaexample.domain

import java.util.UUID

interface ImageUseCases {

    fun getImageBlobByIdAndSize(id: UUID, size: ImageSize): ByteArray
}