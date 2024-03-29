package com.rxjavasample.riddles.solutions

import com.rxjavasample.riddles.Riddle19.Interaction
import io.reactivex.Observable

object Riddle19Solution {
  fun solve(interaction: Interaction)
      = Observable.create<Int> { emitter ->
        interaction.listener = emitter::onNext

        emitter.setCancellable {
          interaction.listener = null
        }
      }
}
