package com.cannonballapps.keycompanion.keys


import android.os.Bundle
import android.support.constraint.ConstraintLayout
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.cannonballapps.keycompanion.Key

import java.lang.StringBuilder
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

    // Todo: probably delete this function
    override fun showKey(toShow: Key) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showAllKeys(keyList: MutableList<Key>) {
        val sb = StringBuilder()
        for (key in keyList) sb.append("${key.curName} ")
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
