package com.andriuswill.testesicredi.data.models

class Event(
    val people: List<People>,
    val date: Long,
    val description: String,
    val image: String,
    val longitude: Double,
    val latitude: Double,
    val price: Double,
    val title: String,
    val id: String,
    val cupons: List<Cupon>
)
