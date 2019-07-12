package com.cannonballapps.keycompanion.Keys


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.cannonballapps.keycompanion.Key

import com.cannonballapps.keycompanion.R

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class KeysFragment : Fragment(), KeysContract.View {
    override fun setPresenter(presenter: KeysContract.Presenter) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showKey(toShow: Key) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showAllKeys(keyList: MutableList<Key>) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_keys, container, false)
    }


}
