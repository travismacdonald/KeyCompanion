package com.cannonballapps.keycompanion.models.keyhandler

import com.cannonballapps.keycompanion.Key

interface KeyHandler {

    fun randomizeKeys(keyList: MutableList<Key>)

    fun toggleKeyName(toToggle: Key)

    fun setAllNamesFlat(keyList: MutableList<Key>)

    fun setAllNamesSharp(keyList: MutableList<Key>)

}