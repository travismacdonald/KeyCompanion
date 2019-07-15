package com.cannonballapps.keycompanion.keys

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.annotation.IdRes
import android.support.v4.app.Fragment
import android.text.TextUtils.replace
import com.cannonballapps.keycompanion.R

class KeysActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.keys_activity)

        val keysFragment = supportFragmentManager.findFragmentById(R.id.contentFrame)
                as KeysFragment? ?: KeysFragment.newInstance().also {
            replaceFragmentInActivity(it, R.id.contentFrame) }
    }
}
