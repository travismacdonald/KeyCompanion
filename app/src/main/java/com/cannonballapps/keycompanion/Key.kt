package com.cannonballapps.keycompanion

/**
 * Class contains two different spellings; flat and sharp.
 * Some cases it may be the same Spelling (flat = C; sharp = C)
 * Other keys contain two different spellings (flat = C#; Db)
 */
class Key(val ix: Int) {

    private enum class Spelling {
        SHARP, FLAT
    }

    private var spellingState = Spelling.FLAT

    private val nameFlat = KeyData.NAMES_FLAT[ix]

    private val nameSharp = KeyData.NAMES_SHARP[ix]

    var name = nameFlat
        private set

    fun toggleName() {
        if (spellingState == Spelling.SHARP) {
            spellingState = Spelling.FLAT
            name = nameFlat
        }
        else {
            spellingState = Spelling.SHARP
            name = nameSharp
        }
    }

    fun setNameFlat() {
        // No action needed if already flat
        if (spellingState == Spelling.SHARP) {
            spellingState = Spelling.FLAT
            name = nameFlat
        }
    }

    fun setNameSharp() {
        // No action needed if already sharp
        if (spellingState == Spelling.FLAT) {
            spellingState = Spelling.SHARP
            name = nameSharp
        }
    }

    override fun toString(): String {
        return name
    }
}
