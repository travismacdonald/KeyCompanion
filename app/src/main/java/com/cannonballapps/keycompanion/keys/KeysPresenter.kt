package com.cannonballapps.keycompanion.keys

import com.cannonballapps.keycompanion.Key
import com.cannonballapps.keycompanion.models.keydatasource.KeysDataSource
import com.cannonballapps.keycompanion.models.keyhandler.KeyHandler

class KeysPresenter(
        private val keysDataSource: KeysDataSource,
        private val keyHandler: KeyHandler,
        private val keysView: KeysContract.View
) : KeysContract.Presenter {

    lateinit var keyList: MutableList<Key>

    override fun finish() {
        keysDataSource.saveKeys(keyList)
    }

    init {
        keysView.presenter = this
    }

    override fun start() {
        keyList = keysDataSource.loadKeys()
        randomizeKeys()
    }

    override fun changeKeySpelling(toChange: Key) {
        keyHandler.toggleKeyName(toChange)
        keysView.showKey(toChange)
    }

    override fun randomizeKeys() {
        keyHandler.randomizeKeys(keyList)
        keysView.showAllKeys(keyList)
    }

    override fun setAllKeysFlat() {
        keyHandler.setAllNamesFlat(keyList)
        keysView.showAllKeys(keyList)
    }

    override fun setAllKeysSharp() {
        keyHandler.setAllNamesSharp(keyList)
        keysView.showAllKeys(keyList)
    }
}