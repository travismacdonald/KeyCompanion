package com.cannonballapps.keycompanion

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

    }
}