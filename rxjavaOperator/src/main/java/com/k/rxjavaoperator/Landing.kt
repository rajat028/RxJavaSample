package com.k.rxjavaoperator

import com.k.rxjavaoperator.patterns.FacadePattern.TestFacadePattern
import com.k.rxjavaoperator.patterns.SingletonPattern
import com.k.rxjavaoperator.patterns.adapterPattern.AdapterTestImpl
import com.k.rxjavaoperator.patterns.builderPattern.TestComputer
import com.k.rxjavaoperator.patterns.composite.TestCompositePattern
import com.k.rxjavaoperator.patterns.factorypattren.AlcoholTestFactory

class Landing {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            singleton()
            factory()
            builderPattern()
            adapterPattern()
            compositePattern()
            facadePattern()
        }

        private fun singleton() {
            val singleton = SingletonPattern.getInstance()
            println("Value ${singleton.value()}")
        }

        private fun factory() {
            val testFactory = AlcoholTestFactory()
            testFactory.getAlcoholTypeWithDetails()
        }

        private fun builderPattern() {
            val testComputer = TestComputer()
            testComputer.getComputer()
        }

        private fun adapterPattern() {
            AdapterTestImpl()
        }

        private fun compositePattern() {
            val testCompositePattern = TestCompositePattern()
            testCompositePattern.startDrawing()
        }

        private fun facadePattern() {
            val testFacadePattern = TestFacadePattern()
            testFacadePattern.generateReport(TestFacadePattern.DBTypes.ORACLE, TestFacadePattern.ReportTypes.PDF)
        }
    }
}
