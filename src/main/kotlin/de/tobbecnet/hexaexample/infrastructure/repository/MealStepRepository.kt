package de.tobbecnet.hexaexample.infrastructure.repository

import de.tobbecnet.hexaexample.infrastructure.MealStepEntity
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Component
import java.util.*

@Component
interface MealStepRepository : CrudRepository<MealStepEntity, UUID> {
}