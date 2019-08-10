package com.cannonballapps.keycompanion.models.keydatasource

import com.cannonballapps.keycompanion.Key

interface KeysDataSource {

    fun loadKeys(): MutableList<Key>

    // Get rid of this bitch
    fun getKey(ix: Int) : Key

    fun randomizeKeys()

    fun toggleKeyName(toChange: Key)

    fun setAllNamesFlat()

    fun setAllNamesSharp()

}