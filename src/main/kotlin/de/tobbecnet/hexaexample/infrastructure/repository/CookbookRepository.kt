package de.tobbecnet.hexaexample.infrastructure.repository

import de.tobbecnet.hexaexample.infrastructure.CookbookEntity
import org.springframework.data.repository.CrudRepository
import java.util.UUID

interface CookbookRepository : CrudRepository<CookbookEntity, UUID> {
}