package de.tobbecnet.hexaexample.infrastructure

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import java.util.UUID


@Entity
class CookbookEntity {

    @Id
    val id: UUID = UUID.randomUUID()
}