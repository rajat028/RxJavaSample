package com.k.rxjavaoperator.patterns.adapterPattern

class Socket {

    fun getVolts(): Volt {
        return Volt(120)
    }
}
