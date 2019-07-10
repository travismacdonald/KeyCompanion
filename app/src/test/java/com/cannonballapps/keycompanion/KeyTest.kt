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
        assertEquals("C", key.curName)

        key.setNameSharp()
        assertEquals("C", key.curName)

        key.setNameFlat()
        assertEquals("C", key.curName)

        key.toggleName()
        assertEquals("C", key.curName)
    }

    // 'C#' <-> 'Db'
    @Test
    fun testDifferentSpelling() {
        val key = Key("D𝄬", "C𝄰")
        assertEquals("D𝄬", key.curName)

        key.toggleName()
        assertEquals("C𝄰", key.curName)

        key.setNameFlat()
        assertEquals("D𝄬", key.curName)

        key.setNameSharp()
        assertEquals("C𝄰", key.curName)
    }

}