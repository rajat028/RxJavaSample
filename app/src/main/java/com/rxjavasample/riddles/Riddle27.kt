package com.rxjavasample.riddles

import io.reactivex.Observable

object Riddle27 {
    /**
     * Call the given [function] each time the [source] emits a value.
     *
     * Use case: Add some logging.
     */
    fun solve(source: Observable<Long>, function: (Long) -> Unit): Observable<Long> {
        return source.doOnNext { function.invoke(it) }
    }
}
