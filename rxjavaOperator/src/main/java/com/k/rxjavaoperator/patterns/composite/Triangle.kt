package com.k.rxjavaoperator.patterns.composite

class Triangle : Shape {

    override fun draw(color: String) {
        println("Filling triangle with color: $color")
    }
}
