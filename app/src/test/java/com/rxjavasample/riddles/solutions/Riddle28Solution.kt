package com.rxjavasample.riddles.solutions

import io.reactivex.Completable

object Riddle28Solution {
  fun solve(source: Completable, function: () -> Unit)
      = source.doOnComplete { function.invoke() }
}
