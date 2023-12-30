package de.tobbecnet.hexaexample.infrastructure.repository

import de.tobbecnet.hexaexample.infrastructure.MealEntity
import org.springframework.data.repository.CrudRepository
import java.util.UUID

interface MealRepository : CrudRepository<MealEntity, UUID> {
}