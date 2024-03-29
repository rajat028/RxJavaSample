package com.rxjavasample.riddles

import io.reactivex.Observable

object Riddle3 {
    /**
     * Don't emit odd numbers from the [source] Observable.
     *
     * Use case: You want to filter certain items out.
     */
    fun solve(source: Observable<Int>): Observable<Int> {
       return source.filter { it % 2 == 0 }
    }
}
