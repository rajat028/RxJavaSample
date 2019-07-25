package com.k.rxjavaoperator.patterns.adapterPattern

class AdapterTestImpl {

    private val socketAdapter = SocketAdapterImpl()
    val _3v = socketAdapter.get3Volts()
    val _12v = socketAdapter.get12Volts()
    val _120v = socketAdapter.getVolts()

    init {
        println("Volts ${_3v.volt}")
    }
}
