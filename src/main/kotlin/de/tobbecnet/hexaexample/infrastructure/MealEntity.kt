package de.tobbecnet.hexaexample.infrastructure

import jakarta.persistence.*
import java.util.*


// TODO https://reflectoring.io/spring-boot-data-jpa-test/


@Entity
class MealEntity {

    @Id
    val id: UUID = UUID.randomUUID()

    @Column(length = 1024, nullable = false)
    val title: String = ""

    @Column
    var introText: String = ""

    @Column(length = 4096, nullable = false)
    val ingredientsAsJson: String = "[]"

    @Column(nullable = false)
    val description: String = ""

    // Unidirectional: Creates intermediate table
    @OneToMany
    val imageCollection: List<PhotoCameraMotiveEntity> = listOf()
}