package de.tobbecnet.hexaexample.infrastructure

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import java.util.UUID


@Entity
class CookbookEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private val id: UUID? = null
}