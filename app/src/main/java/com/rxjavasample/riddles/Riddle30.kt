package com.rxjavasample.riddles

import io.reactivex.Single

object Riddle30 {
    /**
     * Call the given [function] when the [source] is being subscribed to.
     *
     * Use case: Add some logging.
     */
    fun solve(source: Single<Int>, function: () -> Unit): Single<Int> {
        return source.doOnSubscribe { function.invoke() }
    }
}
