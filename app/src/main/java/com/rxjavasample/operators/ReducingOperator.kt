package com.rxjavasample.operators

import io.reactivex.Observable
import io.reactivex.disposables.CompositeDisposable

class ReducingOperator {

    private val compositeDisposable = CompositeDisposable()

    fun reduce() {
        compositeDisposable.add(Observable.range(1, 10)
            .reduce { t1: Int, t2: Int -> t1 + t2 }
            .subscribe {
                println("Output: $it")
            })
    }

}
