package com.rxjavasample.riddles.solutions

import io.reactivex.Completable
import io.reactivex.Scheduler

object Riddle34Solution {
  fun solve(source: Completable, scheduler: Scheduler)
      = source.subscribeOn(scheduler)
}
