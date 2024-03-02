package de.tobbecnet.hexaexample.domain

import java.util.*

interface MealUseCases {

    fun getAllMeals(): Collection<Meal>

    fun getMeal(id: UUID): Meal

    fun addMeal(meal: Meal): Unit

    fun updateMeal(meal: Meal): Unit
}