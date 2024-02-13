package de.tobbecnet.hexaexample.infrastructure.repository

import de.tobbecnet.hexaexample.infrastructure.MealEntity
import de.tobbecnet.hexaexample.infrastructure.PhotoCameraMotiveEntity
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Component
import java.util.*

@Component
interface ImageRepository : CrudRepository<PhotoCameraMotiveEntity, UUID> {
}