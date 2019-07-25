package com.rxjavasample.riddles.solutions

import io.reactivex.Single

object Riddle17Solution {
  fun solve(function: () -> Int)
      = Single.fromCallable(function)
}
