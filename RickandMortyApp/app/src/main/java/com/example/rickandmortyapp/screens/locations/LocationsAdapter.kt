package com.example.rickandmortyapp.screens.locations

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.rickandmortyapp.R
import com.example.rickandmortyapp.model.locations_model.Result
import kotlinx.android.synthetic.main.item_locations_layout.view.*

class LocationsAdapter:RecyclerView.Adapter<LocationsAdapter.LocationsViewHolder>() {
    var listLocations = emptyList<Result>()

    class LocationsViewHolder(view: View): RecyclerView.ViewHolder(view)



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LocationsViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_locations_layout, parent, false)
        return LocationsViewHolder(view)
    }

    override fun onBindViewHolder(holder: LocationsViewHolder, position: Int) {
        holder.itemView.location_name_item.text = listLocations[position].name
        holder.itemView.type_item.text = listLocations[position].type
        holder.itemView.dimension_item.text = listLocations[position].dimension

    }

    override fun getItemCount(): Int {
        return listLocations.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setList(list:List<Result>){
        listLocations=list
        notifyDataSetChanged()
    }
}