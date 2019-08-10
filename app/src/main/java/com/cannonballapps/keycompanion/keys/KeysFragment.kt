package com.cannonballapps.keycompanion.keys

import android.os.Bundle
import android.support.constraint.ConstraintLayout
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.cannonballapps.keycompanion.Key

import com.cannonballapps.keycompanion.R

/**
 * A simple [Fragment] subclass.
 *
 */
class KeysFragment : Fragment(), KeysContract.View {

    private lateinit var keysGridContainer: ConstraintLayout
    // Will call presenter methods through this var.
    override lateinit var presenter: KeysContract.Presenter

    private lateinit var keysGrid: ConstraintLayout
    private lateinit var randomizeButton: Button

    // Key Buttons ordered based on index.
    private var keyButtons = arrayOfNulls<Button>(keysGrid.childCount)

    // Todo: probably delete this function
    override fun showKey(toShow: Key) {
//        for (childNum in 0 until keysGrid.childCount) {
//            if (keysGrid.getChildAt(childNum).getTag())
//        }
    }

    override fun showAllKeys(keyList: MutableList<Key>) {
        for (childNum in 0 until keysGrid.childCount) {
            val curButton = (keysGrid.getChildAt(childNum) as Button)
            curButton.text = keyList[childNum].name
            curButton.tag = keyList[childNum]
            curButton.setOnClickListener { presenter.changeKeySpelling(curButton.tag as Key) }

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

        setupKeyButtons()

        return root
    }

    private fun setupKeyButtons() {
        for (childIx in 0 until keysGrid.childCount) {
            keyButtons[childIx] = keysGrid.getChildAt()
        }
    }

    companion object {

        fun newInstance() = KeysFragment()
    }

}
