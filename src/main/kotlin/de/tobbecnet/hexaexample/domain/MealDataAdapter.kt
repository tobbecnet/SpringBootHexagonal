package de.tobbecnet.hexaexample.domain

import java.util.*

interface MealDataAdapter {

    fun getAllMeals(): Collection<Meal>

    fun getMeal(id: UUID): Meal
}