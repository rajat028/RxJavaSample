package com.k.rxjavaoperator.patterns.factorypattren

class AlcoholFactory {

    companion object {
        fun getAlcohol(alcoholContent: Float, name: String, alcoholPrice: Int): Alcohol {
            return if (alcoholContent == 8.75f)
                Whisky(alcoholPrice, alcoholContent, name)
            else
                Beer(alcoholPrice, alcoholContent, name)
        }
    }
}