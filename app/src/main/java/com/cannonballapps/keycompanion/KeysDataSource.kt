package com.cannonballapps.keycompanion

interface KeysDataSource {

    fun getKey(ix: Int) : Key

    fun randomizeKeys()

    fun toggleKeySpelling(ix: Int)

    fun setAllSpellingFlat()

    fun setAllSpellingSharp()

}