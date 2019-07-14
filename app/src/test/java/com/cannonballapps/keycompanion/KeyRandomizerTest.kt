package com.cannonballapps.keycompanion

import org.junit.Assert.*
import org.junit.Test

class KeyRandomizerTest {

    @Test
    fun shouldPass() {
        assertEquals(2, 2)
    }

    @Test
    fun namesShouldDefaultFlat() {
        val keyRandomizer = KeyRandomizer()
        for (i in 0 until 12) {
            assertEquals(KeyRandomizer.notesFlat[i], keyRandomizer.getKey(i).curName)
        }
    }

    @Test
    fun changeNamesToSharp() {
        val keyRandomizer = KeyRandomizer()
        keyRandomizer.setAllSpellingSharp()
        for (i in 0 until 12) {
            assertEquals(KeyRandomizer.notesSharp[i], keyRandomizer.getKey(i).curName)
        }
    }

    @Test
    fun shuffleKeyList() {
        var different = false
        val regularKr = KeyRandomizer()
        val shuffledKr = KeyRandomizer()

        // Shouldn't flag since keys are in same order.
        for (i in 0 until 12) {
            if (regularKr.getKey(i).curName != shuffledKr.getKey(i).curName) {
                different = true
            }
        }
        assertEquals(false, different)

        // Should flag (fingers crossed) since keys have been shuffled.
        shuffledKr.shuffleKeyList()
        for (i in 0 until 12) {
            if (regularKr.getKey(i).curName != shuffledKr.getKey(i).curName) {
                different = true
            }
        }
        assertEquals(true, different)
    }
}