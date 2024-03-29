package com.rxjavasample.riddles

import io.reactivex.Observable
import io.reactivex.Single

object Riddle24 {
    /**
     * Upon completion of the [source] return a Single containing the number of emissions from [source].
     *
     * Use case: Know how many emissions have been sent out.
     */
    fun solve(source: Observable<Any>): Single<Long> {
        return source.count()
    }
}
