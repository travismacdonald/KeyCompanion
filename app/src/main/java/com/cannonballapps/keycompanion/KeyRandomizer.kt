package com.cannonballapps.keycompanion

class KeyRandomizer {
    companion object {
        const val NUM_NOTES = 12
        val notesFlat = arrayOf("C", "D𝄬", "D", "E𝄬", "E", "F", "G𝄬", "G", "A𝄬", "A", "B𝄬", "B")
        val notesSharp = arrayOf("C", "C𝄰", "D", "D𝄰", "E", "F", "F𝄰", "G", "G𝄰", "A", "A𝄰", "B")
    }

    private var curKeyList = constructKeyList()

    fun getKey(ix: Int) : Key {
        return curKeyList[ix]
    }

    fun shuffleCurNoteList() {
        curKeyList.shuffle()
    }

    // toggleKey
    fun toggleKey(toToggle: Key) {
        toToggle.toggleName()
    }

    fun setAllFlat() {
        for (key in curKeyList) {
            key.setNameFlat()
        }
    }

    fun setAllSharp() {
        for (key in curKeyList) {
            key.setNameSharp()
        }
    }

    private fun constructKeyList() : MutableList<Key> {
        val keyList = mutableListOf<Key>()
        for (i in 0..NUM_NOTES) {
            val curKey = Key(notesFlat[i], notesSharp[i])
            keyList.add(curKey)
        }
        return keyList
    }
}