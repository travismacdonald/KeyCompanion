package com.convergencelabstfx.keycompanion.models.keyhandler

import com.convergencelabstfx.keycompanion.Key

class KeyHandlerImpl : KeyHandler {

    override fun randomizeKeys(keyList: MutableList<Key>) {
        keyList.shuffle()
    }

    override fun toggleKeyName(toToggle: Key) {
        toToggle.toggleName()
    }

    override fun setAllNamesFlat(keyList: MutableList<Key>) {
        for (key in keyList) {
            key.setNameFlat()
        }
    }

    override fun setAllNamesSharp(keyList: MutableList<Key>) {
        for (key in keyList) {
            key.setNameSharp()
        }
    }
}