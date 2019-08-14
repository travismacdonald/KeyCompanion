package com.convergencelabstfx.keycompanion.models.keydatasource

import com.convergencelabstfx.keycompanion.Key
import com.convergencelabstfx.keycompanion.KeyData.Companion.NUM_KEYS

class KeysDataSourceImpl : KeysDataSource {

    override fun loadKeys(): MutableList<Key> {
        val keyList = mutableListOf<Key>()
        for (i in 0 until NUM_KEYS) {
            val curKey = Key(i)
            keyList.add(curKey)
        }
        return keyList
    }

    override fun saveKeys(keyList: MutableList<Key>) {
        TODO("save to prefs") //To change body of created functions use File | Settings | File Templates.
    }


}