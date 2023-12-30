package de.tobbecnet.hexaexample.infrastructure

import de.tobbecnet.hexaexample.domain.MealDataAdapter
import de.tobbecnet.hexaexample.infrastructure.repository.MealRepository

class MealDataAdapterImpl(val mealRepository: MealRepository) : MealDataAdapter {


}