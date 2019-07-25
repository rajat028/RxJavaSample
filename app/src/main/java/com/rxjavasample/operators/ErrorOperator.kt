package com.rxjavasample.operators

import io.reactivex.Observable
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.functions.BiFunction

class ErrorOperator {

    val disposables = CompositeDisposable()

    fun caughtException() {
        disposables.add(observable()
            .doOnNext {
                if (it == 2) {
                    throw (RuntimeException("Exception is on 2"))
                }
                println(it)
            }.subscribe({
                println("Output $it")
            }, {
                println("Exception:  $it")
            })
        )
    }

    fun onExceptionResumeNext() {
        // Whenever there will exception in the pipeline then we can insert another observable by onExceptionResumeNext
        disposables.add(observable()
            .doOnNext {
                if (it == 2)
                    throw (Exception("Exception is on 2"))
            }
            .onExceptionResumeNext {
                Observable.just(10)
            }.subscribe({
                println("Output:  $it")
            }, {
                println("Exception :$it")
            })
        )
    }

    fun onErrorResumeNext() {
        // Whenever there will error not exception in the pipeline then we can insert another observable by onErrorResumeNext
        disposables.add(observable()
            .doOnNext {
                if (it == 2)
                    throw (Exception("Exception on 2"))
            }
            .onErrorResumeNext(Observable.just(10))
            .subscribe({
                println("Output:  $it")
            }, {
                println("Exception :$it")
            })
        )
    }

    fun onErrorReturnItem() {
        disposables.add(observable()
            .doOnNext {
                if (it == 2)
                    throw (Error())
            }
            .onErrorReturnItem(-1)
            .subscribe({
                println("Output:  $it")
            }, {
                println("Exception :$it")
            })
        )
    }

    fun onErrorReturn() {
        disposables.add(observable()
            .doOnNext {
                if (it == 2)
                    throw (Exception("Exception on 2"))
            }
            .onErrorReturn {
                if (it.message == "Exception on 2")
                    10
                else
                    20
            }
            .subscribe({
                println("Output:  $it")
            }, {
                println("Exception :$it")
            })
        )
    }

    private fun observable() = Observable.just(1, 2, 3, 4, 5)
}
