package com.rxjavasample.riddles

import org.junit.Test

class Riddle1Test {
    @Test
    fun solve() {
        Riddle1.solve(5)
            .test()
            .assertResult(5)
    }
}