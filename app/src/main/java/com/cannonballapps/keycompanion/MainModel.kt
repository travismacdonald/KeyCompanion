package com.cannonballapps.keycompanion

class MainModel {
    companion object {
        val numNotes = 12
        val notesFlat = arrayOf("C", "D𝄬", "D", "E𝄬", "E", "F", "G𝄬", "G", "A𝄬", "A", "B𝄬", "B")
        val notesSharp = arrayOf("C", "C𝄰", "D", "D𝄰", "E", "F", "F𝄰", "G", "G𝄰", "A", "A𝄰", "B")
    }

    var curNoteList = notesFlat.toMutableList()
        // find out how to write getter and setter

    fun changeNoteSpelling(note: String) {
        // take note and swap with spelling counterpart (C sharp -> D flat)
    }

    fun shuffleCurNoteList() {
        curNoteList.shuffle()
    }
}