package com.rxjavasample.operators

import io.reactivex.Observable
import io.reactivex.disposables.CompositeDisposable

class CreateOperator {

    private val compositeDisposable = CompositeDisposable()

    fun create() {
        compositeDisposable.add(Observable.create<String> {
            it.onNext("Rajat")
        }.subscribe {
            println("Output $it")
        })
    }

    fun defer() {
        var count = 5
        val observable = Observable
            .defer { Observable.range(0, count) }
        compositeDisposable.add(observable
            .subscribe { println(it) })
        count = 10
        compositeDisposable.add(observable.subscribe {
            println("Second Output $it")
        })

    }
}
