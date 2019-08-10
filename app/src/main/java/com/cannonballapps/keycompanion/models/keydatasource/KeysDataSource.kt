package com.cannonballapps.keycompanion.models.keydatasource

import com.cannonballapps.keycompanion.Key

interface KeysDataSource {

    fun loadKeys(): MutableList<Key>

    fun saveKeys(keyList: MutableList<Key>)

}