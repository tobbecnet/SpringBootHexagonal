package de.tobbecnet.hexaexample.infrastructure

import jakarta.persistence.*
import java.util.*


// TODO https://reflectoring.io/spring-boot-data-jpa-test/


// Representing a single step when preparing, combining, cooking a meal
@Entity
class MealStepEntity {

    @Id
    val id: UUID = UUID.randomUUID()

    @Column(length = 4096, nullable = false)
    var stepDescription: String = ""

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mealEntityId")
    var mealEntity: MealEntity? = null

    @Lob
    @Column
    @Basic(fetch=FetchType.LAZY)            // Does not work without byte code manipulation
    // 375x500, 3:4
    var jpgSmall: ByteArray? = null

    @Lob
    @Column
    @Basic(fetch=FetchType.LAZY)            // Checkout if enableLazyInitialization does anything in spring boot 3
    // 750x1000, 3:4
    var jpgLarge: ByteArray? = null
}