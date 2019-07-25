package com.rxjavasample.riddles.solutions

import io.reactivex.Observable

object Riddle7Solution {
  fun solve(source: Observable<Int>)
      = source.distinct()
}
