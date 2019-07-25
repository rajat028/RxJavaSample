package com.rxjavasample.riddles.solutions

import io.reactivex.Observable

object Riddle4Solution {
  fun solve(source: Observable<Unit>)
      = source.scan(false) { toggle, _ -> !toggle }
}
