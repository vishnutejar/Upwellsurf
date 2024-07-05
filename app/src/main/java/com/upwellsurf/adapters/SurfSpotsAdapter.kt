package com.upwellsurf.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.upwellsurf.ContentView
import com.upwellsurf.R
import com.upwellsurf.interfaces.IOnItemSelectedSports
import com.upwellsurf.models.SurfSpot

class SurfSpotsAdapter(
    var listOfSpots: MutableList<SurfSpot>,
    var onItemSelectedSports: IOnItemSelectedSports
) :
    RecyclerView.Adapter<SurfSpotsAdapter.SurfSpotsViewHolder>() {

    class SurfSpotsViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        val title = ItemView.findViewById<TextView>(R.id.txt_location_title)
        val decription = ItemView.findViewById<TextView>(R.id.txt_location_dec)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SurfSpotsViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_location_info, parent, false)
        return SurfSpotsViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listOfSpots.size
    }

    override fun onBindViewHolder(holder: SurfSpotsViewHolder, position: Int) {
        val ItemsViewModel = listOfSpots[position]
        holder.title.setText(ItemsViewModel.name)
        holder.decription.setText(ItemsViewModel.location)
        holder.itemView.setOnClickListener {
            onItemSelectedSports.onItemSelected(position)
        }

    }

    fun updateList(searchValue: String) {
        listOfSpots.clear()
        listOfSpots.addAll(ContentView().surfSpots.filter { a ->
            a.name.lowercase().contains(searchValue.lowercase())
        })
        this.notifyDataSetChanged()
    }
}