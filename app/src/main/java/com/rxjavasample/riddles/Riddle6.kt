package com.rxjavasample.riddles

import io.reactivex.Single
import io.reactivex.functions.BiFunction

object Riddle6 {
    /**
     * Execute both [first] and [second] Single's in parallel and provide both results as a pair.
     * Assume both [first] and [second] will execute on a different thread already.
     * This is a slightly simpler version of [Riddle102], where no schedulers are applied by default.
     *
     * Use case: Execute two network requests in parallel and wait for each other and process the combined data.
     */
    fun solve(first: Single<Int>, second: Single<Int>): Single<Pair<Int, Int>> {
        return Single.zip(first, second, BiFunction<Int, Int, Pair<Int, Int>> { t1, t2 -> t1 to t2 })
    }
}
