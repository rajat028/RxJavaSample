package com.rxjavasample

import io.reactivex.Observable
import io.reactivex.functions.BiFunction
import io.reactivex.schedulers.TestScheduler
import org.junit.Before
import org.junit.Test
import java.util.concurrent.TimeUnit


class FilteringOperatorTest {

    lateinit var scheduler: TestScheduler

    @Before
    fun setUp() {
        scheduler = TestScheduler()
    }

    @Test
    fun `should emit first three items with take operator`() {
        val observable = stubObservable()
            .take(3)
            .test()

        observable.assertValues(1, 5, 6)
    }

    @Test
    fun `should take values less than 6`() {
        val observable = stubObservable()
            .takeWhile { it < 6 }
            .test()

        observable.assertValues(1, 5)
    }

    @Test
    fun `should emit single value greater than five`() {
        val observable = stubObservable()
            .takeLast(3)
            .test()

        observable.assertValues(6, 6, 9)
    }

    @Test
    fun `should emit first value from source`() {
        val observable = stubObservable()
            .first(3)
            .test()

        observable.assertValue(1)
    }

    @Test
    fun `should emit last value from source`() {
        val observable = stubObservable()
            .last(3)
            .test()

        observable.assertValue(9)
    }

    @Test
    fun `should emit value at specified element`() {
        val observable = stubObservable()
            .elementAt(2)
            .test()

        observable.assertValue(6)
    }

    @Test
    fun `should emit only string type values`() {
        val observable = Observable.just("One", "two", 3, 4)
            .ofType(String::class.java)
            .test()

        observable.assertValues("One", "two")
    }

    @Test
    fun `should skip first two elements`() {
        val observable = stubObservable()
            .skip(2)
            .toList()
            .test()

        observable.assertResult(mutableListOf(6, 6, 9))
    }

    @Test
    fun `should skip values till condition passes`() {
        val observable = stubObservable()
            .skipWhile { it < 5 }
            .test()

        observable.assertValues(5, 6, 6, 9)
    }

    @Test
    fun `should Skip Last Three values`() {
        val observable = stubObservable()
            .skipLast(3)
            .test()

        observable.assertValues(1, 5)
    }

    @Test
    fun `should extract distinct values`() {
        val observable = Observable.just(1, 2, 3, 4, 1, 4, 3, 2)
            .distinct()
            .toList()
            .test()

        observable.assertResult(mutableListOf(1, 2, 3, 4))
    }

    @Test
    fun `should emit distinct continuous item`() {
        val observable = Observable.just(1, 1, 3, 2, 2, 4, 3, 2, 2, 1)
            .distinctUntilChanged()
            .test()

        observable.assertValues(1, 3, 2, 4, 3, 2, 1)
    }

    @Test
    fun `should emit zero values`() {
        val observable = stubObservable()
            .ignoreElements()
            .test()

        observable.assertValueCount(0)
    }

    @Test
    fun `should emit values under specified period`() {
        scheduler.advanceTimeBy(7, TimeUnit.SECONDS)

        val observable = stubObservable()
            .zipWith(Observable.interval(1, TimeUnit.SECONDS), BiFunction<Int, Long, Int> { t1, _ -> t1 })
            .sample(2, TimeUnit.SECONDS, scheduler)
            .test()

        observable.assertValues(1, 6)
    }

    private fun stubObservable() = Observable.just(1, 5, 6, 6, 9)
}
