package com.rxjavasample.riddles

import io.reactivex.Completable

object Riddle28 {
    /**
     * Call the given [function] when the [source] completes.
     *
     * Use case: Add some logging.
     */
    fun solve(source: Completable, function: () -> Unit): Completable {
        return source.doOnComplete { function.invoke() }
    }
}
