package com.cannonballapps.keycompanion.Keys

import com.cannonballapps.keycompanion.BasePresenter
import com.cannonballapps.keycompanion.BaseView
import com.cannonballapps.keycompanion.Key

interface KeysContract {

    interface View :
        BaseView<Presenter> {

        fun showAllKeys(keyList: MutableList<Key>)

        fun showKey(toShow: Key)

    }

    interface Presenter : BasePresenter {

        fun randomizeKeys()

        fun setAllKeysSharp()

        fun setAllKeysFlat()

        fun changeKeySpelling(toChange: Key)

    }
}