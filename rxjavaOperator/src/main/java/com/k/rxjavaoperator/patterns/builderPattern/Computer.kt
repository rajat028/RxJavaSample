package com.k.rxjavaoperator.patterns.builderPattern

class Computer(computerBuilder: ComputerBuilder) {

    var ram: Int = 0
    var hardisk: Int = 0

    var isGraphicCardAvailable: Boolean = false
    var isDualDisplayAvailable: Boolean = false

    init {
        this.ram = computerBuilder.ram
        this.hardisk = computerBuilder.hardisk
        this.isDualDisplayAvailable = computerBuilder.isDualDisplayAvailable
        this.isGraphicCardAvailable = computerBuilder.isGraphicCardAvailable
    }

    class ComputerBuilder(var ram: Int, var hardisk: Int) {

        var isGraphicCardAvailable: Boolean = false
        var isDualDisplayAvailable: Boolean = false

        fun setGraphicCard(graphicCardAvailability: Boolean): ComputerBuilder {
            this.isGraphicCardAvailable = graphicCardAvailability
            return this
        }

        fun setDualDisplay(dualDisplayAvailability: Boolean): ComputerBuilder {
            this.isDualDisplayAvailable = dualDisplayAvailability
            return this
        }

        fun build(): Computer {
            return Computer(this)
        }
    }

    fun computerSpecifications(): String {
        return "Computer Specifications RAM: $ram HDD: $hardisk Graphic Card: $isGraphicCardAvailable Dual Mode:$isDualDisplayAvailable"
    }
}
