package de.tobbecnet.hexaexample.infrastructure

import jakarta.persistence.*
import jakarta.validation.constraints.Size
import java.util.*


// TODO https://reflectoring.io/spring-boot-data-jpa-test/


@Entity
class MealEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private val id: UUID? = null

    @Column(length = 1024, nullable = false)
    private val title: String = ""

    @Column(nullable = false)
    private var introText: String = ""
}