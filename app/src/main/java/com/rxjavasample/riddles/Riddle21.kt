package com.rxjavasample.riddles

import io.reactivex.Observable

object Riddle21 {
    /**
     * Return the first emission of the [source] in a blocking fashion.
     *
     * Use case: Sometimes you can't do everything reactively and need to break out of it.
     */
    fun solve(source: Observable<Int>): Int {
        return source.blockingFirst()
    }
}