package com.rxjavasample.riddles.solutions

import io.reactivex.Observable

object Riddle18Solution {
  fun solve(first: Observable<Int>, second: Observable<Int>)
      = Observable.ambArray(first, second)
}
