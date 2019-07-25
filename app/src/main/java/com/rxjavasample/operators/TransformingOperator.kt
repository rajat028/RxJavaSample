package com.rxjavasample.operators

import com.rxjavasample.model.First
import com.rxjavasample.model.FullName
import io.reactivex.Observable
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.functions.BiFunction
import io.reactivex.functions.Function
import io.reactivex.schedulers.Schedulers
import java.util.concurrent.TimeUnit
import kotlin.random.Random

class TransformingOperator {

    private val disposable = CompositeDisposable()

    fun scan() {
        // Scan operator is similar to reduce operator in that both apply aggregating function on the values emitted
        // by source observable with one difference. Reduce operator creates an observable which emits final value after
        // applying aggregating function on all values emitted by source observable.
        // Whereas scan operator creates an observable which emits all values returned by the function.
        disposable.add(Observable.fromIterable(names())
            .map { t: First -> t.firstName.length }
            .scan { t1: Int, t2: Int -> t1 + t2 }
            .subscribe { println("The output would be $it") })
    }

    fun map() {
        disposable.add(
            Observable.just("One", "two", "three", "four")
                .map { it.length }
                .subscribe {
                    println("The output would be $it")
                })
    }

    fun zip() {
        val observable1 = Observable.create<String> {
            for (i in 1..10) {
                println("Emission 1 $i on thread id: ${Thread.currentThread().id}")
                it.onNext(i.toString())
            }
        }.subscribeOn(Schedulers.newThread())

        val observable2 = Observable.create<String> {
            for (i in 1..10) {
                println("Emission 2 $i on thread id: ${Thread.currentThread().id}")
                it.onNext(i.toString())
            }
        }.subscribeOn(Schedulers.newThread())

        disposable.add(Observable.zip(
            observable1,
            observable2,
            BiFunction<String, String, Pair<String, String>> { t1, t2 -> Pair(t1, t2) }
        )
            .subscribe {
                println("${it.first} would be ${it.second}")
            }
        )
    }

    fun flatMap() {
        disposable.add(Observable.fromIterable(names())
            .flatMap {
                val delayCount: Int = Random.nextInt(4)
                Observable.just(it)
                    .delay(delayCount.toLong(), TimeUnit.SECONDS)
            }
            .toList()
            .subscribe({ println(it[0])}, { println(it.localizedMessage)})
        )
    }

    fun switchMap() {
        disposable.add(Observable.fromIterable(names())
            .switchMap {
                Observable.just(it)
                    .delay(1, TimeUnit.SECONDS)
            }
            .map(convertToFullName())
            .subscribe { println(it.fullName) }
        )
    }

    fun concatMap() {
        disposable.add(Observable.fromIterable(names())
            .concatMap {
                val delayCount: Int = Random.nextInt(4)
                Observable.just(it)
                    .delay(delayCount.toLong(), TimeUnit.SECONDS)
            }
            .map(convertToFullName())
            .subscribe { println(it.fullName) }
        )
    }

    fun groupBy() {
        disposable.add(Observable.just("Rajat", "Ravi", "Shashi", "Achal")
            .groupBy { it.length }
            .flatMapSingle {
                it.toList()
            }
            .subscribe {
                println("Grouped $it")
            })
    }

    private fun convertToFullName(): Function<First, FullName> {
        return Function {
            FullName("${it.firstName} Arora")
        }
    }

    private fun names(): MutableList<First> {
        val names = mutableListOf<First>()
        names.add(First("Rajat"))
        names.add(First("Achal"))
        names.add(First("Ravi"))
        names.add(First("Shashi"))
        return names
    }
}

