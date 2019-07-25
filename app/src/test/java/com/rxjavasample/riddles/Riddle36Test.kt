package com.rxjavasample.riddles

import com.rxjavasample.riddles.solutions.Riddle36Solution
import com.rxjavasample.riddles.tools.RxRule
import io.reactivex.subjects.PublishSubject
import org.junit.Rule
import org.junit.Test
import java.util.concurrent.TimeUnit.MILLISECONDS

/** Solution [Riddle36Solution] */
class Riddle36Test {
  @get:Rule val rxRule = RxRule()

  @Test fun solve() {
    val source = PublishSubject.create<String>()
    val milliseconds = 100L

    val o = Riddle36.solve(source, milliseconds)
        .test()
        .assertEmpty()

    source.onNext("H")

    rxRule.advanceTimeBy(milliseconds - 1, MILLISECONDS)
    o.assertEmpty()

    rxRule.advanceTimeBy(1, MILLISECONDS)
    o.assertValuesOnly("H")

    source.onNext("He")

    rxRule.advanceTimeBy(milliseconds - 1, MILLISECONDS)
    o.assertValuesOnly("H")

    source.onNext("Hello")
    rxRule.advanceTimeBy(1, MILLISECONDS)
    o.assertValuesOnly("H")

    rxRule.advanceTimeBy(milliseconds, MILLISECONDS)
    o.assertValues("H", "Hello")
  }
}
