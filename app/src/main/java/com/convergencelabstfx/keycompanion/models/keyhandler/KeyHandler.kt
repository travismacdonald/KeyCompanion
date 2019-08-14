package com.convergencelabstfx.keycompanion.models.keyhandler

import com.convergencelabstfx.keycompanion.Key

interface KeyHandler {

    fun randomizeKeys(keyList: MutableList<Key>)

    fun toggleKeyName(toToggle: Key)

    fun setAllNamesFlat(keyList: MutableList<Key>)

    fun setAllNamesSharp(keyList: MutableList<Key>)

}