package com.cannonballapps.keycompanion.keys

import com.cannonballapps.keycompanion.Key
import com.cannonballapps.keycompanion.models.keydatasource.KeysDataSource

class KeysPresenter(
        val keysDataSource: KeysDataSource,
        val keysView: KeysContract.View
) : KeysContract.Presenter {

    // Todo: reference to KeyHandlerImpl
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
        keysDataSource.randomizeKeys()
        keysView.showAllKeys(keysDataSource.loadKeys())
    }

    override fun setAllKeysFlat() {
        keysDataSource.setAllNamesFlat()
        keysView.showAllKeys(keysDataSource.loadKeys())
    }

    override fun setAllKeysSharp() {
        keysDataSource.setAllNamesSharp()
        keysView.showAllKeys(keysDataSource.loadKeys())    }
}