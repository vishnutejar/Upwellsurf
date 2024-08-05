package com.upwellsurf.views

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.doOnTextChanged
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.VERTICAL
import com.upwellsurf.ContentView
import com.upwellsurf.R
import com.upwellsurf.adapters.SurfSpotsAdapter
import com.upwellsurf.interfaces.IOnItemSelectedSports
import com.upwellsurf.models.SurfSpot

class DashboardActivity : AppCompatActivity(), IOnItemSelectedSports {
    lateinit var reCySpots: RecyclerView
    lateinit var adapter_custome: SurfSpotsAdapter
    lateinit var clearSearchValue: ImageView
    lateinit var etSearchView: EditText
    lateinit var txt_live_report: TextView
    lateinit var txt_seven_forcast: TextView
    lateinit var listOfSpots: MutableList<SurfSpot>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)
        supportActionBar?.hide()
        clearSearchValue = findViewById(R.id.im_clearbt)
        reCySpots = findViewById(R.id.recyclerview)
        etSearchView = findViewById(R.id.et_search)
        txt_seven_forcast = findViewById(R.id.txt_seven_forcast)
        txt_live_report = findViewById(R.id.txt_live_report)
        listOfSpots = ContentView().surfSpots
        adapter_custome = SurfSpotsAdapter(listOfSpots, this)
        reCySpots.layoutManager = LinearLayoutManager(this, VERTICAL, false)
        reCySpots.adapter = adapter_custome
        clearSearchValue.setOnClickListener {
            etSearchView.text.clear()
            val imm =
                this.getSystemService(Context.INPUT_METHOD_SERVICE) as
                        InputMethodManager
            imm.hideSoftInputFromWindow(this.clearSearchValue.windowToken, 0)
        }
        txt_live_report.setOnClickListener {
            val intent = Intent(this, LiveReportActivity::class.java)
            startActivity(intent)
        }

        etSearchView.addTextChangedListener(object : TextWatcher {

            override fun afterTextChanged(s: Editable) {}

            override fun beforeTextChanged(
                s: CharSequence, start: Int,
                count: Int, after: Int
            ) {
            }

            override fun onTextChanged(
                s: CharSequence, start: Int,
                before: Int, count: Int
            ) {
                adapter_custome.updateList(s.toString())

            }
        })

        txt_seven_forcast.setOnClickListener {
            var gotoSevenForcastActivity=Intent(this,SevenForcastActivity::class.java)
            startActivity(gotoSevenForcastActivity)
        }
    }

    override fun onItemSelected(position: Int) {
        val selectedItem = listOfSpots[position]
        val navigatingToDetails = Intent(this, SurfSpotDetailsActivity::class.java)
        navigatingToDetails.putExtra("name", selectedItem.name)
        startActivity(navigatingToDetails)
    }
}