package com.rxjavasample.riddles.solutions

import io.reactivex.Observable

object Riddle23Solution {
  fun solve(source: Observable<Any>)
      = source.cast(String::class.java)
}
