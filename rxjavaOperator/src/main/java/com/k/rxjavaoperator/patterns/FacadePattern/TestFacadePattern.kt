package com.k.rxjavaoperator.patterns.FacadePattern

class TestFacadePattern {

    fun generateReport(dbTypes: DBTypes, reportTypes: ReportTypes) {
        when (dbTypes) {
            DBTypes.MYSQL -> {
                val sqliteDatabase = SqliteDatabase()
                when (reportTypes) {
                    ReportTypes.PDF -> sqliteDatabase.generateReport(ReportTypes.PDF)
                    ReportTypes.HTML -> sqliteDatabase.generateReport(ReportTypes.HTML)
                }
            }
            DBTypes.ORACLE ->{
                val oracleDatabase = OracleDatabase()
                when(reportTypes){
                    ReportTypes.PDF -> oracleDatabase.generateReport(ReportTypes.PDF)
                    ReportTypes.HTML -> oracleDatabase.generateReport(ReportTypes.HTML)
                }
            }
        }

    }

    enum class DBTypes {
        MYSQL,
        ORACLE
    }

    enum class ReportTypes {
        PDF,
        HTML
    }
}
