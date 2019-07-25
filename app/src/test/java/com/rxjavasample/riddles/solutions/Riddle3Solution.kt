package com.rxjavasample.riddles.solutions

import io.reactivex.Observable

object Riddle3Solution {
  fun solve(source: Observable<Int>)
      = source.filter { it.rem(2) == 0 }
}
