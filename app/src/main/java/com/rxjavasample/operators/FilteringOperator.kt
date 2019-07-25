package com.rxjavasample.operators

import io.reactivex.Observable
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.zipWith
import java.util.concurrent.TimeUnit

class FilteringOperator {

    private val disposables = CompositeDisposable()

    fun take() {
        // The logic results in the emission of the first n items while ignoring the remaining items.
        disposables.add(Observable.range(1, 10)
            .take(5)
            .subscribe { output(it) })
        // output - 1, 2, 3, 4, 5
    }

    fun takeWhile() {
        // This will keep emitting items until it encounters a first element that doesn’t match the Predicate.
        disposables.add(Observable.just(1, 5, 6, 6, 9)
            .takeWhile { it < 6 }
            .toList()
            .subscribe { t: MutableList<Int>? -> println("Take While: $t") })
        // output - 1, 5
    }

    fun takeUntill() {
        // This will keep emitting elements till it encounters a first element that does match the predicate.
        disposables.add(Observable.just(6, 9, 6, 2, 9)
            .takeUntil { it < 6 }
            .toList()
            .subscribe { t: MutableList<Int>? -> println("Take Untill: $t") })
        // Output - 6, 9, 6, 2
    }

    fun takeLast() {
        // The logic results in the emission of the last n items while ignoring the other items.
        disposables.add(Observable.just(1, 2, 5, 6, 8, 9)
            .takeLast(2)
            .subscribe { output(it) })
        // output - 8, 9
    }

    fun first() {
        // The logic results in the emission of the first item while ignoring the other items
        // and if the source is empty then it would emit default value.
        disposables.add(Observable.just(1, 2, 5, 6, 8, 9)
            .first(7)
            .subscribe { t: Int -> output(t) })
    }

    fun last() {
        // The logic results in the emission of the last item while ignoring the other items
        // and if the source is empty then it would emit default value.
        disposables.add(Observable.just(1, 2, 5, 6, 8, 9)
            .last(7)
            .subscribe { t: Int -> output(t) })
    }

    fun elementAt() {
        // With the elementAt operator, we can pick a single item emitted by the source Observable,
        // specifying its index:

        //However, elementAt will throw an IndexOutOfBoundException if the specified index exceeds
        // the number of items emitted.

        //To avoid this situation, it’s possible to use elementAt(2, defaultItem)
        // – which will return a default value in case the index is out of range.

        disposables.add(Observable.just(1, 1, 5, 6, 8)
            .elementAt(2)
            .subscribe { println("Element at index 3: $it") })
        // Output - 5
    }

    fun ofType() {
        // Whenever the Observable emits Object items, it’s possible to filter them based on their type.
        disposables.add(Observable.just("One", "two", 3, 4)
            .ofType(String::class.java)
            .subscribe {
                println("The String values would be: $it")
            })
        // Output - One, two
    }

    fun skip() {
        // skip some of the firsts emitted items using skip.
        disposables.add(
            observable()
                .skip(2)
                .toList()
                .subscribe { t: MutableList<Int>? ->
                    println("Output after skipped items: $t")
                })
        // Output - 3, 4, 5, 6, 7
    }

    fun skipWhile() {
        // To filter out all the first values emitted by an Observable that fail a filtering predicate.
        disposables.add(observable()
            .skipWhile { it < 2 }
            .subscribe { output(it) })
        // Output - 2, 3, 4, 5, 6, 7
    }

    fun skipLast() {
        // Skip the final items emitted by the Observable accepting only those emitted before them.
        disposables.add(observable()
            .skipLast(3)
            .subscribe { output(it) })
        // Output - 1, 2, 3, 4
    }

    fun distinct() {
        // This emits all the items emitted by the sourceObservable that are distinct
        disposables.add(Observable.just(1, 2, 3, 4, 1, 4, 3, 2)
            .distinct()
            .toList()
            .subscribe { t: MutableList<Int>? -> println("Distinct Output would be $t") })
        // Output - 1, 2, 3, 4
    }

    fun distinctUntilChanged() {
        // The items emitted by the sourceObservable that are distinct from their immediate predecessor
        disposables.add(Observable.just(1, 1, 3, 2, 2, 4, 3, 2, 2, 1)
            .distinctUntilChanged()
            .subscribe {
                println(output(it))
            })
        // Output - 1, 3, 2, 4, 3, 2, 1
    }

    fun ignoreElements() {
        // To ignore all the elements emitted by the sourceObservable,
        disposables.add(observable()
            .ignoreElements()
            .subscribe {
                println("Output would be empty")
            })
    }

    fun sample() {
        disposables.add(observableWithInterval()
            .sample(2500, TimeUnit.MILLISECONDS)
            .subscribe {
                output(it.first)
            })
    }

    fun throttleFirst() {
        disposables.add(observableWithInterval().doOnNext {
            println("On Next ${it.first}")
        }
            .throttleFirst(2100, TimeUnit.MILLISECONDS)
            .subscribe {
                output(it.first)
            })
    }

    fun throttleLast() {
        disposables.add(observableWithInterval()
            .throttleLast(2, TimeUnit.SECONDS)
            .subscribe {
                output(it.first)
            })
    }

    fun debounce() {
        disposables.add(observableWithInterval()
            .debounce(2, TimeUnit.SECONDS)
            .subscribe {
                println(output(it.first))
            })
    }

    fun sorted() {
        disposables.add(Observable.just("Ravi", "Shashi", "Rajat", "Achal")
            .sorted { o1, o2 -> o1.compareTo(o2) }
            .subscribe { println("Sorted Output: $it") })
    }


    private fun observableWithInterval() = observable()
        .zipWith(Observable.interval(1, TimeUnit.SECONDS))

    private fun observable() = Observable.just(1, 2, 3, 4, 5, 6, 7)

    private fun output(it: Int?) {
        println("Output $it")
    }
}
