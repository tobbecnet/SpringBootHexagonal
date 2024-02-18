package de.tobbecnet.hexaexample.domain

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import java.util.*


enum class PhotoMotiveSize {
    Small, Medium, Large
}

enum class MealStepMotiveSize {
    Small, Large
}


// Now here would be the place where we can do things with the found images. But what should we do here?
// Maybe we just inject the imageDataAdapter into the controller...
@Component
class ImageServiceImpl(
    @Autowired val imageDataAdapter: ImageDataAdapter
) : ImageUseCases {


    override fun getPhotoMotiveBlobByMotiveIdAndSize(motiveId: UUID, motiveSize: PhotoMotiveSize): ByteArray {
        return imageDataAdapter.getImageBlobByIdAndSize(motiveId, motiveSize)
    }

    override fun getMealHeroImageBlobByMealId(mealId: UUID): ByteArray {
        return imageDataAdapter.getMealHeroImageBlobByMealId(mealId)
    }

    override fun getMealStepImageBlobByMealStepIdAndSize(
        mealStepId: UUID,
        mealStepMotiveSize: MealStepMotiveSize
    ): ByteArray {
        return imageDataAdapter.getMealStepImageBlobByMealStepIdAndSize(mealStepId, mealStepMotiveSize)
    }
}