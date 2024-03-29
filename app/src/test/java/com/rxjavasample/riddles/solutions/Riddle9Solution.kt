package com.rxjavasample.riddles.solutions

import io.reactivex.Observable

object Riddle9Solution {
  fun solve(main: Observable<Unit>, trigger: Observable<Unit>)
      = main.takeUntil(trigger)
}
