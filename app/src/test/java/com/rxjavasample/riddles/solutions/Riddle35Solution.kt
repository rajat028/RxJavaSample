package com.rxjavasample.riddles.solutions

import io.reactivex.Maybe
import io.reactivex.Single

object Riddle35Solution {
  fun solve(first: Maybe<String>, second: Single<String>)
      = first.switchIfEmpty(second)
}
