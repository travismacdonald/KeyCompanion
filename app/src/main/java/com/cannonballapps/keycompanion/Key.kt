package com.cannonballapps.keycompanion

class Key(nameFlat: String, nameSharp: String) {

    private val nameArr = arrayOf(nameFlat, nameSharp)
    private var nameIx = 0
    // Set to flat by default.
    var curName = nameArr[nameIx]
        private set

    fun toggleName() {
        nameIx = (nameIx + 1) % nameArr.size
        curName = nameArr[nameIx]
    }

    fun setNameFlat() {
        if (nameIx != 0) {
            nameIx = 0
            curName = nameArr[0]
        }
    }

    fun setNameSharp() {
        if (nameIx != 1) {
            nameIx = 1
            curName = nameArr[1]
        }
    }
}
