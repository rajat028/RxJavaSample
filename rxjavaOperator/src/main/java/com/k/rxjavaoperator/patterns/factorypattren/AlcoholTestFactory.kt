package com.k.rxjavaoperator.patterns.factorypattren

class AlcoholTestFactory {

    fun getAlcoholTypeWithDetails() {
        val alcohol = AlcoholFactory.getAlcohol(8.75f, "Red Label", 1000)
        println("The alcohol type is ${alcohol::class.java}")
    }
}
