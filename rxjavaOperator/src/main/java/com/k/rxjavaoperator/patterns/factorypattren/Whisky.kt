package com.k.rxjavaoperator.patterns.factorypattren


class Whisky(private val price: Int, private val content: Float, private val name: String) : Alcohol() {
    override fun getAlcoholPrice(): Int {
        return price
    }

    override fun getAlcoholContent(): Float {
        return content
    }

    override fun getAlcoholName(): String {
        return name
    }
}
