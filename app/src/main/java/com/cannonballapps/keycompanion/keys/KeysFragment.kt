package com.cannonballapps.keycompanion.keys


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import com.cannonballapps.keycompanion.Key

import com.cannonballapps.keycompanion.R
import java.lang.StringBuilder

/**
 * A simple [Fragment] subclass.
 *
 */
class KeysFragment : Fragment(), KeysContract.View {

    // Will call presenter methods through this var.
    override lateinit var presenter: KeysContract.Presenter

    private lateinit var keysStr: TextView
    private lateinit var randomizeButton: Button

    // Todo: probably delete this function
    override fun showKey(toShow: Key) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showAllKeys(keyList: MutableList<Key>) {
        val sb = StringBuilder()
        for (key in keyList) sb.append("${key.curName} ")
        keysStr.text = sb.toString()
    }

    override fun onResume() {
        super.onResume()
        presenter.start() // TODO: not implemented yet
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val root = inflater.inflate(R.layout.keys_frag, container, false)
        with (root) {
            keysStr = findViewById(R.id.keys_text)
            randomizeButton = findViewById(R.id.randomize_button)
            randomizeButton.setOnClickListener { presenter.randomizeKeys() }
        }
        return root
    }

    companion object {

        fun newInstance() = KeysFragment()
    }

}
