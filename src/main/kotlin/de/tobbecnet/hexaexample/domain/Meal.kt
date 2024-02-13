package de.tobbecnet.hexaexample.domain

import jakarta.validation.constraints.Size


// TODO https://www.studytonight.com/spring-boot/spring-boot-validations#:~:text=Spring%20Boot%20Validation%20Implementation%3A&text=%40Size%20annotation%20is%20used%20to,default%20message%20on%20validation%20failure.


data class Meal(
    @Size(min = 5, max = 1024) var title: String,
    var introText: String?,
    var ingredients: List<Ingredient>,
    var description: String,
    var images: List<ImageMetadata>)