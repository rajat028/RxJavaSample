package com.rxjavasample.riddles.solutions

import io.reactivex.Observable

object Riddle25Solution {
  fun solve(source: Observable<Int>)
      = source.defaultIfEmpty(5)
}
