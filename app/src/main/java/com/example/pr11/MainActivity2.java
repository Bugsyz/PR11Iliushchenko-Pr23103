package com.example.pr11;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class MainActivity2 extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) ImageView rocket = findViewById(R.id.rocket);
        Animation fly = AnimationUtils.loadAnimation(this, R.anim.rocket_fly);
        rocket.startAnimation(fly);
    }
}