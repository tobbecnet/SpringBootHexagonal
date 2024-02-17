package de.tobbecnet.hexaexample.infrastructure

import jakarta.persistence.*
import java.util.*


// TODO https://reflectoring.io/spring-boot-data-jpa-test/


@Entity
class MealEntity {

    @Id
    val id: UUID = UUID.randomUUID()

    @Column(length = 1024, nullable = false)
    var title: String = ""

    @Column(length = 2048, nullable = true)
    var introText: String? = ""

    @Column(length = 4096, nullable = false)
    var ingredientsAsJson: String = "[]"

    @Column(length = 4096, nullable = false)
    var description: String = ""

    @Column(length = 1024, nullable = false)
    var categoriesAsJson: String = "[]"

    @Lob
    @Column(nullable = false)
    @Basic(fetch=FetchType.LAZY)            // Does not work without byte code manipulation
    // 1280x720, 16:9
    var heroImageJpg: ByteArray = null!!

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "mealEntity")
    var mealSteps: List<MealStepEntity> = listOf()

    // Unidirectional, creates intermediate table
    @ManyToMany
    @JoinTable(
        name="meal_to_photo_motive_im",
        joinColumns = [JoinColumn(name="meal_id")],
        inverseJoinColumns = [JoinColumn(name="photo_motive_id")]
    )
    val photoMotiveCollection: List<PhotoCameraMotiveEntity> = listOf()
}