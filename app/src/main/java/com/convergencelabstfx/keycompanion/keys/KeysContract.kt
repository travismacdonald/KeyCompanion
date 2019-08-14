package com.convergencelabstfx.keycompanion.keys

import com.convergencelabstfx.keycompanion.BasePresenter
import com.convergencelabstfx.keycompanion.BaseView
import com.convergencelabstfx.keycompanion.Key

interface KeysContract {

    interface View : BaseView<Presenter> {

        fun showAllKeys(keyList: MutableList<Key>)

        fun showKey(toShow: Key)

    }

    interface Presenter : BasePresenter {

        fun randomizeKeys()

        fun setAllKeysSharp()

        fun setAllKeysFlat()

        fun changeKeySpelling(toChange: Key)

        fun finish()

    }
}