package com.cannonballapps.keycompanion.keys

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.cannonballapps.keycompanion.models.keyhandler.KeyHandlerImpl
import com.cannonballapps.keycompanion.R

class KeysActivity : AppCompatActivity() {

    private lateinit var keysPresenter: KeysPresenter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.keys_activity)


        val keysFragment = supportFragmentManager.findFragmentById(R.id.contentFrame) as KeysFragment?
                ?: KeysFragment.newInstance()

        val transaction = supportFragmentManager.beginTransaction()
        transaction.add(R.id.contentFrame, keysFragment).commit()

        keysPresenter = KeysPresenter(KeyHandlerImpl(), keysFragment)

//        // Todo: borken
//        supportFragmentManager
//            .beginTransaction()
//            .add(R.id.contentFrame, KeysFragment.newInstance())
//            .commit()
    }
}
