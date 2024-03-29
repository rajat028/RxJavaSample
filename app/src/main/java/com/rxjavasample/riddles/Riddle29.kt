package com.rxjavasample.riddles

import io.reactivex.Maybe

object Riddle29 {
  /**
   * Call the given [function] when the [source] errors.
   *
   * Use case: Add some logging.
   */
  fun solve(source: Maybe<Int>, function: (Throwable) -> Unit): Maybe<Int> {
    return source.doOnError(function)
  }
}
