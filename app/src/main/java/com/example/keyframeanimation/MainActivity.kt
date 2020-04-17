package com.example.keyframeanimation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.transition.TransitionManager
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintSet
import androidx.core.content.res.ResourcesCompat

class MainActivity : AppCompatActivity() {

    lateinit var mRoot: ConstraintLayout
    lateinit var mSearchEditText: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mRoot = findViewById(R.id.root)
        mSearchEditText = findViewById(R.id.search)
        findViewById<View>(R.id.clear).setOnClickListener { mSearchEditText.text.clear() }
        setTransition()
    }

    private fun setTransition() {
        val constraint1 = ConstraintSet()
        constraint1.clone(this, R.layout.activity_main)
        val constraint2 = ConstraintSet()
        constraint2.clone(this, R.layout.activity_main_alt)

        findViewById<View>(R.id.search).setOnClickListener{
            TransitionManager.beginDelayedTransition(mRoot)
            constraint2.applyTo(mRoot)
        }

        findViewById<View>(R.id.cancel).setOnClickListener {
            TransitionManager.beginDelayedTransition(mRoot)
            constraint1.applyTo(mRoot)
        }
    }
}
