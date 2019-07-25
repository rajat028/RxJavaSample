package com.rxjavasample.riddles.solutions

import io.reactivex.Observable

object Riddle21Solution {
  fun solve(source: Observable<Int>)
      = source.blockingFirst()
}
