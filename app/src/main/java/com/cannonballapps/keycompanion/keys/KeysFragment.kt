package com.cannonballapps.keycompanion.keys

import android.os.Bundle
import android.support.constraint.ConstraintLayout
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.cannonballapps.keycompanion.Key
import com.cannonballapps.keycompanion.KeyData

import com.cannonballapps.keycompanion.R

/**
 * A simple [Fragment] subclass.
 *
 */
class KeysFragment : Fragment(), KeysContract.View {

    private lateinit var keysGridContainer: ConstraintLayout

    private lateinit var keysGrid: ConstraintLayout

    private lateinit var randomizeButton: Button

    override lateinit var presenter: KeysContract.Presenter

    // Key Buttons ordered by key index.
    private var keyButtons = arrayOfNulls<Button>(KeyData.NUM_KEYS)

    // Todo: probably delete this function
    override fun showKey(toShow: Key) {
        keyButtons[toShow.ix]?.text = toShow.name
    }

    override fun showAllKeys(keyList: MutableList<Key>) {
        for (childIx in 0 until keysGrid.childCount) {
            val curButton = (keysGrid.getChildAt(childIx) as Button)
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
            randomizeButton = findViewById(R.id.randomize_button)
            randomizeButton.setOnClickListener { presenter.randomizeKeys() }
        }

        return root
    }

    companion object {

        fun newInstance() = KeysFragment()
    }

}
