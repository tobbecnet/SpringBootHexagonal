package de.tobbecnet.hexaexample.domain

data class Ingredient(
    val quantity: String,
    val unit: String?,
    val ingredient: String,
    val additionalDescription: String?
)