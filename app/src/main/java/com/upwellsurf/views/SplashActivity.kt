package com.upwellsurf.views

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.animation.Animation
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.animation.AnimationUtils
import com.upwellsurf.R


class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        supportActionBar?.hide()
        Handler(mainLooper).postDelayed({
            startActivity(
                Intent(
                    this,
                    LoginActivity::class.java
                ).apply { Intent.FLAG_ACTIVITY_SINGLE_TOP })
            finish()
        }, 2000)
    }
}