package com.upwellsurf.views

import android.content.Intent
import android.graphics.drawable.AnimationDrawable
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import com.upwellsurf.R


class LoginActivity : AppCompatActivity() {
    private var animationDrawable: AnimationDrawable? = null
    lateinit var bt_login: Button
    lateinit var main: ConstraintLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        supportActionBar?.hide()
        main = findViewById(R.id.main)
        bt_login=findViewById(R.id.bt_login)
        animationDrawable = main.background as AnimationDrawable?
        animationDrawable?.setEnterFadeDuration(3000)
        animationDrawable?.setExitFadeDuration(2000)
        bt_login.setOnClickListener {
            var gotoDashboardActivity= Intent(this,DashboardActivity::class.java)
            startActivity(gotoDashboardActivity)
        }

    }

    override fun onResume() {
        super.onResume()
        if (animationDrawable != null && !animationDrawable!!.isRunning) {
            animationDrawable!!.start()
        }
    }

    override fun onPause() {
        super.onPause()
        if (animationDrawable != null && !animationDrawable!!.isRunning) {
            animationDrawable!!.stop()
        }
    }

}