package com.cannonballapps.keycompanion.keys

import com.cannonballapps.keycompanion.Key
import com.cannonballapps.keycompanion.KeysDataSource

class KeysPresenter(
    val keysDataSource: KeysDataSource,
    val keysView: KeysContract.View
) : KeysContract.Presenter {

    // Todo: reference to KeyRandomizer
    // Todo: reference to KeysFragment

    init {
        keysView.presenter = this
    }

    override fun start() {
        randomizeKeys()
    }

    override fun changeKeySpelling(toChange: Key) {
        keysDataSource.toggleKeyName(toChange)
        keysView.showKey(toChange)
    }

    override fun randomizeKeys() {
        keysDataSource.randomizeKeyOrder()
        keysView.showAllKeys(keysDataSource.getKeys())
    }

    override fun setAllKeysFlat() {
        keysDataSource.setAllNamesFlat()
        keysView.showAllKeys(keysDataSource.getKeys())
    }

    override fun setAllKeysSharp() {
        keysDataSource.setAllNamesSharp()
        keysView.showAllKeys(keysDataSource.getKeys())    }
}