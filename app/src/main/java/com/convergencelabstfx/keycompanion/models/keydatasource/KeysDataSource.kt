package com.convergencelabstfx.keycompanion.models.keydatasource

import com.convergencelabstfx.keycompanion.Key

interface KeysDataSource {

    fun loadKeys(): MutableList<Key>

    fun saveKeys(keyList: MutableList<Key>)

}