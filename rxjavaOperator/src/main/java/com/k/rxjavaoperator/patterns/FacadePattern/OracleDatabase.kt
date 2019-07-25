package com.k.rxjavaoperator.patterns.FacadePattern

class OracleDatabase {

    fun generateReport(pdf: TestFacadePattern.ReportTypes) {
        println("Generating Oracle report in $pdf format")
    }
}
