package de.tobbecnet.hexaexample.domain

data class Meal(val ingredients: Map<String, String>, var description: String, var imageAsBase64Data: String)