package de.tobbecnet.hexaexample.domain

import java.util.*


// The domain object for images just holds the necessary data to create links
// to the image controller.

data class Image(
    val id: UUID,
    val type: String)