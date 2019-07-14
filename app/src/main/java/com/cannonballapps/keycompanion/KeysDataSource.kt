package com.cannonballapps.keycompanion

interface KeysDataSource {

    fun getKey(ix: Int) : Key

    fun randomizeKeyOrder()

    fun toggleKeyName(toChange: Key)

    fun setAllNamesFlat()

    fun setAllNamesSharp()

}