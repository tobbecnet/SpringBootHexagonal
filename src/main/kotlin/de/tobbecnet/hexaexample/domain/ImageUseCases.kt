package de.tobbecnet.hexaexample.domain

import java.util.UUID

interface ImageUseCases {

    fun getPhotoMotiveBlobByMotiveIdAndSize(motiveId: UUID, motiveSize: PhotoMotiveSize): ByteArray

    fun getMealHeroImageBlobByMealId(mealId: UUID): ByteArray

    fun getMealStepImageBlobByMealStepIdAndSize(mealStepId: UUID, mealStepMotiveSize: MealStepMotiveSize): ByteArray
}