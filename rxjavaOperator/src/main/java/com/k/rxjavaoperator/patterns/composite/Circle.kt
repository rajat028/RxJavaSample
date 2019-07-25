package com.k.rxjavaoperator.patterns.composite

class Circle : Shape {

    override fun draw(color: String) {
        println("Filling circle with color: $color")
    }
}
