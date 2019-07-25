package com.rxjavasample.riddles.solutions

import io.reactivex.Observable

object Riddle31Solution {
  fun solve(source: Observable<Int>)
      = source.repeat(3)
}
