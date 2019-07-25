package com.k.rxjavaoperator.patterns.composite

class TestCompositePattern {

    private val triangle = Triangle()
    private val circle = Circle()
    private val drawing = Drawing()

    init {
        drawing.addShape(triangle)
        drawing.addShape(circle)
        drawing.addShape(circle)
        drawing.addShape(triangle)
    }

    fun startDrawing() {
        drawing.draw("Blue")
    }
}
