package com.k.rxjavaoperator.patterns.builderPattern

class TestComputer {

    fun getComputer() {
        val computer = Computer.ComputerBuilder(1024, 80)
            .setDualDisplay(true)
            .setGraphicCard(true)
            .build()
        println(computer.computerSpecifications())
    }
}
