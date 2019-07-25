package com.rxjavasample.riddles

import com.rxjavasample.riddles.solutions.Riddle12Solution
import io.reactivex.Observable
import org.junit.Test

/** Solution [Riddle12Solution] */
class Riddle12Test {
  @Test fun solve() {
    Riddle12.solve(Observable.create {
      it.onNext(1)
      it.onNext(2)
      it.onError(RuntimeException())
    })
        .test()
        .assertResult(1, 2, 5)
  }
}
