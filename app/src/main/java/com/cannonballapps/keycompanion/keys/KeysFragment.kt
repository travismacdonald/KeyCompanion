package com.cannonballapps.keycompanion.keys

import android.os.Bundle
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import com.cannonballapps.keycompanion.Key
import com.cannonballapps.keycompanion.KeyData

import com.cannonballapps.keycompanion.R
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton

class KeysFragment : androidx.fragment.app.Fragment(), KeysContract.View {

    private lateinit var keysGridContainer: ConstraintLayout

    private lateinit var keysGrid: ConstraintLayout

    private lateinit var randomizeButton: ExtendedFloatingActionButton

    private lateinit var sharpButton: ExtendedFloatingActionButton

    private lateinit var flatButton: ExtendedFloatingActionButton

    override lateinit var presenter: KeysContract.Presenter

    // Key Buttons ordered by key index.
    private var keyButtons = arrayOfNulls<ExtendedFloatingActionButton>(KeyData.NAMES_FLAT.size)

    // Todo: probably delete this function
    override fun showKey(toShow: Key) {
        keyButtons[toShow.ix]?.text = toShow.name
    }

    override fun showAllKeys(keyList: MutableList<Key>) {
//        val testFab = ((keysGrid.getChildAt(0) as LinearLayout).getChildAt(0) as ExtendedFloatingActionButton)
//        testFab.text = keyList[0].name
//        testFab.tag = keyList[0]
//        testFab.setOnClickListener { presenter.changeKeySpelling(testFab.tag as Key) }

        for (childIx in 0 until keysGrid.childCount) {
            val curButton = ((keysGrid.getChildAt(childIx) as LinearLayout)
                    .getChildAt(0) as ExtendedFloatingActionButton)
            curButton.text = keyList[childIx].name
            curButton.tag = keyList[childIx]
            curButton.setOnClickListener { presenter.changeKeySpelling(curButton.tag as Key) }
            keyButtons[keyList[childIx].ix] = curButton
        }
    }

    override fun onResume() {
        super.onResume()
        presenter.start() // TODO: not implemented yet
    }

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val root = inflater.inflate(R.layout.keys_frag, container, false)
        keysGridContainer = root.findViewById(R.id.keys_grid)
        keysGrid = inflater.inflate(R.layout.keys_item, root as ViewGroup, false) as ConstraintLayout
        keysGridContainer.addView(keysGrid)

        with (root) {
            // Setup Buttons

            randomizeButton = (findViewById<LinearLayout>(R.id.randomize_button)).getChildAt(0) as ExtendedFloatingActionButton
            randomizeButton.setOnClickListener { presenter.randomizeKeys() }

            flatButton = (findViewById<LinearLayout>(R.id.flat_button)).getChildAt(0) as ExtendedFloatingActionButton
            flatButton.setOnClickListener { presenter.setAllKeysFlat() }

            sharpButton = (findViewById<LinearLayout>(R.id.sharp_button)).getChildAt(0) as ExtendedFloatingActionButton
            sharpButton.setOnClickListener { presenter.setAllKeysSharp() }
        }

        return root
    }

    companion object {

        fun newInstance() = KeysFragment()
    }

}
