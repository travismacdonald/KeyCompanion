package com.cannonballapps.keycompanion

/**
 * Class contains two different spellings; flat and sharp.
 * Some cases it may be the same spelling (flat = C; sharp = C)
 * Other keys contain two different spellings (flat = C#; Db)
 */
class Key(nameFlat: String, nameSharp: String) {

    /**
     * Array of possible name spellings.
     */
    private val nameArr = arrayOf(nameFlat, nameSharp)

    /**
     * Index of current name spelling.
     * 0 = flat; 1 = sharp.
     */
    private var nameIx = 0

    /**
     * Current name spelling.
     * No setter, can only be changed by functions listed below.
     */
    var curName = nameArr[nameIx]
        private set

    /**
     * Toggles name between sharp and flat.
     * Used when user wants to change current spelling of key.
     */
    fun toggleName() {
        nameIx = (nameIx + 1) % nameArr.size
        curName = nameArr[nameIx]
    }

    /**
     * Set name to sharp spelling if flat.
     */
    fun setNameFlat() {
        if (nameIx != 0) {
            nameIx = 0
            curName = nameArr[0]
        }
    }

    /**
     * Set name to flat spelling if sharp.
     */
    fun setNameSharp() {
        if (nameIx != 1) {
            nameIx = 1
            curName = nameArr[1]
        }
    }
}
