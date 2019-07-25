package com.k.rxjavaoperator.patterns.adapterPattern

interface SocketAdapter {

    fun getVolts(): Volt

    fun get3Volts(): Volt

    fun get12Volts(): Volt
}
