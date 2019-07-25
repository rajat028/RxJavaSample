package com.k.rxjavaoperator.patterns.FacadePattern

class SqliteDatabase {

    fun generateReport(pdf: TestFacadePattern.ReportTypes) {
        println("Sqlite report generated in PDF form")
    }
}
