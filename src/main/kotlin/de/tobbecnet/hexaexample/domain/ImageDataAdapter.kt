package de.tobbecnet.hexaexample.domain

import java.util.UUID

interface ImageDataAdapter {

    fun getImageBlobByIdAndSize(id: UUID, size: PhotoMotiveSize): ByteArray

    fun getMealHeroImageBlobByMealId(mealId: UUID): ByteArray

    fun getMealStepImageBlobByMealStepIdAndSize(mealStepId: UUID, mealStepMotiveSize: MealStepMotiveSize): ByteArray
}