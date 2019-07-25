package com.k.rxjavaoperator.patterns.composite

class Drawing : Shape {

    private val shapes = mutableListOf<Shape>()

    override fun draw(color: String) {
        for (shape in shapes) {
            shape.draw(color)
        }
    }

    fun addShape(shape: Shape) {
        shapes.add(shape)
    }

    fun removeShape(shape: Shape) {
        shapes.remove(shape)
    }

    fun removeAllShapes() {
        shapes.clear()
    }
}
