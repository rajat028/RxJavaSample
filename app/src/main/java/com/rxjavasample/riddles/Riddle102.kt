package com.rxjavasample.riddles

import io.reactivex.Single
import io.reactivex.functions.BiFunction
import io.reactivex.schedulers.Schedulers

object Riddle102 {
    /**
     * Execute both [first] and [second] Single's in parallel and provide both results as a pair.
     *
     * Use case: Execute two network requests in parallel and wait for each other and process the combined data.
     */
    fun solve(first: Single<Int>, second: Single<Int>): Single<Pair<Int, Int>> {
        return Single.zip(
            first.subscribeOn(Schedulers.io()),
            second.subscribeOn(Schedulers.io()),
            BiFunction<Int, Int, Pair<Int, Int>> { t1, t2 -> t1 to t2 }
        )
    }
}
