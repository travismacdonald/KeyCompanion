package com.cannonballapps.keycompanion

class KeyRandomizer : KeysDataSource {
    companion object {
        /**
         * Total number of keys.
         */
        const val NUM_KEYS = 12

        /**
         * Flat spelling of key names.
         */
        val keysFlat = arrayOf("C", "D𝄬", "D", "E𝄬", "E", "F", "G𝄬", "G", "A𝄬", "A", "B𝄬", "B")

        /**
         * Sharp spelling of key names.
         */
        val keysSharp = arrayOf("C", "C𝄰", "D", "D𝄰", "E", "F", "F𝄰", "G", "G𝄰", "A", "A𝄰", "B")
    }

    /**
     * Stores list of key objects (ordered).
     */
    private var curKeyList = constructKeyList()

    /**
     * Get key matching index given.
     */
    override fun getKey(ix: Int) : Key {
        return curKeyList[ix]
    }

    /**
     * Randomizes order of key list.
     */
    override fun randomizeKeyOrder() {
        curKeyList.shuffle()
    }

    /**
     * Calls keys toggle method.
     */
    override fun toggleKeyName(toChange: Key) {
        toChange.toggleName()
    }

    /**
     * Sets all keys spelling to flat.
     */
    override fun setAllNamesFlat() {
        for (key in curKeyList) {
            key.setNameFlat()
        }
    }

    /**
     * Sets all keys spelling to sharp.
     */
    override fun setAllNamesSharp() {
        for (key in curKeyList) {
            key.setNameSharp()
        }
    }

    /**
     * Inflates key list with 12 key objects (ordered).
     * Default spelling is flat.
     */
    private fun constructKeyList() : MutableList<Key> {
        val keyList = mutableListOf<Key>()
        for (i in 0 until NUM_KEYS) {
            val curKey = Key(keysFlat[i], keysSharp[i])
            keyList.add(curKey)
        }
        return keyList
    }
}