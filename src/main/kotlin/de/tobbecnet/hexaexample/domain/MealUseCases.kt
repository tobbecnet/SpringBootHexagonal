package de.tobbecnet.hexaexample.domain

interface MealUseCases {

    fun getAllMeals(): Collection<Meal>

    fun addMeal(meal: Meal): Unit

    fun updateMeal(meal: Meal): Unit
}