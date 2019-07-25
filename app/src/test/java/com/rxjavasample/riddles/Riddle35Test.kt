package com.rxjavasample.riddles

import com.rxjavasample.riddles.solutions.Riddle35Solution
import com.rxjavasample.riddles.tools.RxRule
import io.reactivex.Maybe
import io.reactivex.Single
import org.junit.Rule
import org.junit.Test

/** Solution [Riddle35Solution] */
class Riddle35Test {
  @get:Rule val rxRule = RxRule()

  @Test fun hit() {
    val first = Maybe.just("First")
    val second = Single.just("Second")

    Riddle35.solve(first, second)
        .test()
        .assertResult("First")
  }

  @Test fun miss() {
    val first = Maybe.empty<String>()
    val second = Single.just("Second")

    Riddle35.solve(first, second)
        .test()
        .assertResult("Second")
  }
}
