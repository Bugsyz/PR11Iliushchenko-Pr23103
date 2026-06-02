package com.example.pr11

import android.annotation.SuppressLint
import android.app.Activity
import android.os.Bundle
import android.view.animation.AnimationUtils
import android.widget.ImageView

class MainActivity : Activity() {

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val rocket = findViewById<ImageView>(R.id.rocket)

        val fly = AnimationUtils.loadAnimation(this, R.anim.rocket_fly)

        rocket.startAnimation(fly)
    }
}