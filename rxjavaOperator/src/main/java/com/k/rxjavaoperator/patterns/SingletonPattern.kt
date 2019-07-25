package com.k.rxjavaoperator.patterns

class SingletonPattern {

    companion object {
       private class SingletonHelper {
            companion object {
                val INSTANCE = SingletonPattern()
            }
        }

        fun getInstance(): SingletonPattern {
            return SingletonHelper.INSTANCE
        }
    }

    fun value(): String{
        return "Singleton"
    }
}
