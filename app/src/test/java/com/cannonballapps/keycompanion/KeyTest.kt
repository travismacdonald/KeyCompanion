package com.cannonballapps.keycompanion

import org.junit.Assert.*
import org.junit.Test

class KeyTest {

    @Test
    fun shouldPass() {
        assertEquals(2, 2)
    }

    // 'C' is spelled the same whether sharp or flat.
    @Test
    fun testSameSpelling() {
        val key = Key("C", "C")
        assertEquals("C", key.name)

        key.setNameSharp()
        assertEquals("C", key.name)

        key.setNameFlat()
        assertEquals("C", key.name)

        key.toggleName()
        assertEquals("C", key.name)
    }

    // 'C#' <-> 'Db'
    @Test
    fun testDifferentSpelling() {
        val key = Key("D𝄬", "C𝄰")
        assertEquals("D𝄬", key.name)

        key.toggleName()
        assertEquals("C𝄰", key.name)

        key.setNameFlat()
        assertEquals("D𝄬", key.name)

        key.setNameSharp()
        assertEquals("C𝄰", key.name)
    }

}