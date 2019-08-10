package com.cannonballapps.keycompanion.models.keyhandler

import com.cannonballapps.keycompanion.Key

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

//    /**
//     * Inflates key list with 12 key objects (ordered).
//     * Default spelling is flat.
//     */
//    private fun constructKeyList() : MutableList<Key> {
//        val keyList = mutableListOf<Key>()
//        for (i in 0 until NUM_KEYS) {
//            val curKey = Key(keysFlat[i], keysSharp[i])
//            keyList.add(curKey)
//        }
//        return keyList
//    }
}