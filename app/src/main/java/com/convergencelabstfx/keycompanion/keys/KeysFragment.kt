package com.convergencelabstfx.keycompanion.keys

import android.os.Bundle
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout

import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton
import android.view.animation.AlphaAnimation
import android.view.animation.Animation
import androidx.core.content.res.ResourcesCompat
import com.convergencelabstfx.keycompanion.Key
import com.convergencelabstfx.keycompanion.KeyData
import com.convergencelabstfx.keycompanion.R

class KeysFragment : androidx.fragment.app.Fragment(), KeysContract.View {

    // Added overhead for animation. Haven't got it to work properly yet.

    private val FADE_DURATION: Long = 200

    private val INVISIBLE = 0f

    private val VISIBLE = 1f

    private lateinit var mFadeIn: Animation

    private lateinit var mFadeOut: Animation

    private lateinit var keysGridContainer: ConstraintLayout

    private lateinit var keysGrid: ConstraintLayout

    private lateinit var randomizeButton: ExtendedFloatingActionButton

    private lateinit var sharpButton: ExtendedFloatingActionButton

    private lateinit var flatButton: ExtendedFloatingActionButton

    override lateinit var presenter: KeysContract.Presenter

    // Key Buttons ordered by key index.
    private var keyButtons = arrayOfNulls<ExtendedFloatingActionButton>(KeyData.NAMES_FLAT.size)

    override fun showKey(toShow: Key) {
        keyButtons[toShow.ix]?.text = toShow.name
//        keyButtons[toShow.ix]?.text = toShow.name
//        keyButtons[toShow.ix]?.let { animateKeyButtonText(toShow.name, it) }
    }

    override fun showAllKeys(keyList: MutableList<Key>) {
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

        setupFont()
//        setupTextAnimators()

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

    private fun setupFont() {
        val typeface = context?.let { ResourcesCompat.getFont(it, R.font.deja_vu_sans_fam) }
        for (childIx in 0 until keysGrid.childCount) {
            ((keysGrid.getChildAt(childIx) as LinearLayout).getChildAt(0) as ExtendedFloatingActionButton).typeface = typeface
        }
    }

    private fun animateKeyButtonText(newText: String, view: ExtendedFloatingActionButton) {
        mFadeOut.setAnimationListener(object : Animation.AnimationListener {
            override fun onAnimationStart(animation: Animation) { /* Not used. */ }

            override fun onAnimationEnd(animation: Animation) {
                view.text = newText
                view.startAnimation(mFadeIn)
            }

            override fun onAnimationRepeat(animation: Animation) { /* Not used. */ }
        })
        view.startAnimation(mFadeOut)
    }

    private fun setupTextAnimators() {
        mFadeIn = AlphaAnimation(INVISIBLE, VISIBLE)
        mFadeIn.duration = FADE_DURATION

        mFadeOut = AlphaAnimation(VISIBLE, INVISIBLE)
        mFadeOut.duration = FADE_DURATION
    }

    companion object {

        fun newInstance() = KeysFragment()
    }

}
