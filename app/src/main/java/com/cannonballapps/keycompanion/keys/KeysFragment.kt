package com.cannonballapps.keycompanion.keys


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.cannonballapps.keycompanion.Key

import com.cannonballapps.keycompanion.R

/**
 * A simple [Fragment] subclass.
 *
 */
class KeysFragment : Fragment(), KeysContract.View {

    // Will call presenter methods through this var.
    override lateinit var presenter: KeysContract.Presenter

    override fun showKey(toShow: Key) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showAllKeys(keyList: MutableList<Key>) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onResume() {
        super.onResume()
        presenter.start() // TODO: not implemented yet
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val root = inflater.inflate(R.layout.keys_frag, container, false)

        return root
    }

    companion object {

        fun newInstance() = KeysFragment()
    }

}
