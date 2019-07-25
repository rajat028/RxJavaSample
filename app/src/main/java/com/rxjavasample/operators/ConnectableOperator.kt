package com.rxjavasample.operators

import io.reactivex.Observable
import java.util.concurrent.TimeUnit

class ConnectableOperator {

    fun publishOperator() {
        // This would connect all the subscribers to source observable and emission will work in parallel i.e both
        // subscriber will get the emission at same time
        // Point - We have to call the connect after all the subscribers, if we call subscribe after connect it will not work.
        val source = Observable.just(
            "Alpha", "Beta", "Gamma",
            "Delta", "Epsilon"
        ).publish()
        source.subscribe { s -> println("Observer 1: $s") }
        source.map(String::length)
            .subscribe { i -> println("Observer 2: $i") }
        source.connect()
        source.subscribe { println("After Connect: ${it.toUpperCase()}") }
    }

    fun replayOperator() {
        // Replay operator returns ConnectableObservable that starts emitting items only after connect is called on it.
        // Replay operator is similar to publish operator except that it will replay all items emitted by
        // source observable to future observers.
        val source = Observable.just(
            "Alpha", "Beta", "Gamma",
            "Delta", "Epsilon"
        ).replay()

        source.subscribe { s -> println("Observer 1: $s") }
        source.map(String::length)
            .subscribe { i -> println("Observer 2: $i") }
        source.connect()
        source.subscribe { println("After Connect: ${it.toUpperCase()}") }
    }

    fun autoConnectOperator() {
        // The autoConnect() operator on ConnectableObservable can be quite handy. For a given ConnectableObservable<T>,
        // calling autoConnect() will return an Observable<T> that will automatically call connect() after a specified
        // number of Observers are subscribed. If we don't specify the count of subscriber to autoconnect by default it
        // will consider that 1.

        val source = Observable.interval(1, TimeUnit.SECONDS)
            .publish()
            .autoConnect(2)
            .take(20)

        source.subscribe {
            println("Observer 1: $it")
        }
        sleep(3000)
        source.subscribe {
            println("Observer 2: $it")
        }
        sleep(3000)
        source.subscribe {
            println("Observer 3: $it")
        }
    }

    fun refCount() {
        // The refCount() operator on ConnectableObservable is similar to
        //autoConnect(1), which fires after getting one subscription. But there is one important difference; when it has
        // no Observers anymore, it will dispose of itself and start over when a new one comes in.
        // It does not persist the subscription to the source when it has no more Observers, and when another Observer
        // follows, it will essentially "start over".

        val source = Observable.just(
            "Alpha", "Beta", "Gamma", "Delta",
            "Epsilon"
        )
            .publish()
            .refCount()


        source.subscribe {
            println("Observer 1: $it")
        }

        source.subscribe {
            println("Observer 2: $it")
        }

        source.subscribe {
            println("Observer 3: $it")
        }
    }

    fun sleep(milis: Long) {
        try {
            Thread.sleep(milis)
        } catch (e: Exception) {
            println("Exception: $e")
        }
    }
}
