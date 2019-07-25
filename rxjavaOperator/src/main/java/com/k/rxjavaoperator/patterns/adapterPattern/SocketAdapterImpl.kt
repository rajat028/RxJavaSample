package com.k.rxjavaoperator.patterns.adapterPattern

class SocketAdapterImpl : SocketAdapter {

    private val socket = Socket()

    override fun getVolts(): Volt {
        return socket.getVolts()
    }

    override fun get3Volts(): Volt {
        val volts = socket.getVolts()
        return convertVolt(volts, 40)
    }

    override fun get12Volts(): Volt {
        val volts = socket.getVolts()
        return convertVolt(volts, 10)
    }

    private fun convertVolt(volts: Volt, i: Int): Volt {
        return Volt(volts.volt / i)
    }
}
