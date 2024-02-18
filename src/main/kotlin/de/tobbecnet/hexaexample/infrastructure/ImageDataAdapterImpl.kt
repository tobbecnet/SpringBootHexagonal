package de.tobbecnet.hexaexample.infrastructure

import de.tobbecnet.hexaexample.domain.ImageDataAdapter
import de.tobbecnet.hexaexample.domain.MealStepMotiveSize
import de.tobbecnet.hexaexample.domain.PhotoMotiveSize
import de.tobbecnet.hexaexample.exception.ImageBlobNotFoundException
import de.tobbecnet.hexaexample.infrastructure.repository.ImageRepository
import de.tobbecnet.hexaexample.infrastructure.repository.MealRepository
import de.tobbecnet.hexaexample.infrastructure.repository.MealStepRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import java.util.*


// Main purpose of this adapter implementation is mapping db entities to domain objects.
@Component
class ImageDataAdapterImpl(
    @Autowired val imageRepository: ImageRepository,
    @Autowired val mealRepository: MealRepository,
    @Autowired val mealStepRepository: MealStepRepository
) : ImageDataAdapter {

    override fun getImageBlobByIdAndSize(photoMotiveId: UUID, photoMotiveSize: PhotoMotiveSize): ByteArray {
        return imageRepository
            .findById(photoMotiveId)
            .orElseThrow()
            .let { entity ->
                when (photoMotiveSize) {
                    PhotoMotiveSize.Small -> entity.jpgSmall
                    PhotoMotiveSize.Medium -> entity.jpgMedium
                    PhotoMotiveSize.Large -> entity.jpgLarge
                }
            }
            ?: throw ImageBlobNotFoundException(
                "No photo motive image found for id $photoMotiveId, size $photoMotiveSize"
            )
    }

    override fun getMealHeroImageBlobByMealId(mealId: UUID): ByteArray {
        return mealRepository
            .findById(mealId)
            .orElseThrow()
            .heroImageJpg ?: throw ImageBlobNotFoundException("No hero image found for id $mealId")
    }

    override fun getMealStepImageBlobByMealStepIdAndSize(
        mealStepId: UUID,
        mealStepMotiveSize: MealStepMotiveSize
    ): ByteArray {
        return mealStepRepository
            .findById(mealStepId)
            .orElseThrow()
            .let { entity ->
                when (mealStepMotiveSize) {
                    MealStepMotiveSize.Small -> entity.jpgSmall
                    MealStepMotiveSize.Large -> entity.jpgLarge
                }
            }
            ?: throw ImageBlobNotFoundException(
                "No meal step image found for id $mealStepId, size $mealStepMotiveSize"
            )
    }
}