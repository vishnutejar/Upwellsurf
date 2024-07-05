package com.upwellsurf.views

import android.os.Bundle
import android.view.MenuItem
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.upwellsurf.ContentView
import com.upwellsurf.R


class SurfSpotDetailsActivity : AppCompatActivity() {
    lateinit var txtTitle: TextView
    lateinit var txt_buoyReport: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_surf_spot_details)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        txtTitle = findViewById(R.id.txt_title)
        txt_buoyReport = findViewById(R.id.txt_buoyReport)
        val name = intent.getStringExtra("name")
        val details = ContentView().surfSpotForecasts.find { a -> a.spotName.equals(name) }

        txtTitle.text = name
        txt_buoyReport.text = details?.buoyReport

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                onBackPressed()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }
}