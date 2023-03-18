package com.example.logInRabbit.data

import kotlin.random.Random

class Lists {
    private val listKitchen = listOf ("Estufa", "Cuchara", "Tenedor", "Olla", "Jarra", "Vaso", "Comedor", "Silla")
    val randomValues = List(listKitchen.size) { Random.nextInt(0, listKitchen.size) }
}