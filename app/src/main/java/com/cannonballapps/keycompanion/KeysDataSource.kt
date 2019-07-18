package com.cannonballapps.keycompanion

interface KeysDataSource {

    fun getKeys(): MutableList<Key>

    fun getKey(ix: Int) : Key

    fun randomizeKeyOrder()

    fun toggleKeyName(toChange: Key)

    fun setAllNamesFlat()

    fun setAllNamesSharp()

}