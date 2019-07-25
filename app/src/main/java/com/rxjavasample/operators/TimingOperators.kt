package com.rxjavasample.operators

import io.reactivex.Observable
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.functions.BiFunction
import io.reactivex.schedulers.Schedulers
import java.util.concurrent.TimeUnit

class TimingOperators {

    private val disposable = CompositeDisposable()

    fun timerOperator() {
        // This operator will perform the specified task after 2 Seconds
        disposable.add(
            Observable.timer(2, TimeUnit.SECONDS)
                .flatMap {
                    Observable.create<String> { emitter ->
                        emitter.onNext("Task performed after 2 Seconds")
                        emitter.onComplete()
                    }
                }
                .subscribeOn(Schedulers.io())
                .subscribe {
                    println("Output: $it")
                })
    }

    fun delayOperator() {
        // This operator will perform the task at the same time but emit after 2 seconds
        disposable.add(
            Observable.just("Emission after 2 Seconds")
                .delay(2, TimeUnit.SECONDS)
                .subscribeOn(Schedulers.io())
                .subscribe {
                    println("Output: $it")
                })
    }

    fun intervalOperator() {
        // This operator will perform the specified task after 1 Second and keep on doing the same after
        // the specified time
        disposable.add(Observable.interval(1, TimeUnit.SECONDS)
            .flatMap {
                Observable.create<String> { emitter ->
                    emitter.onNext("Task output after 2 Seconds")
                }
            }.take(5)
            .subscribeOn(Schedulers.io())
            .subscribe {
                println("Output: $it")
            })
    }
}
