package com.rxjavasample.riddles

import io.reactivex.Observable

object Riddle2 {
    /**
     * Increment each emitted value of the given [source] by 1.
     *
     * Use case: You want to transform the data.
     */
    fun solve(source: Observable<Int>): Observable<Int> {
        return source.map { it + 1 }
    }
}
