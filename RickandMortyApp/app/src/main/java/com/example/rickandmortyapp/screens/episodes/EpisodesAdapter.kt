package com.example.rickandmortyapp.screens.episodes

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.rickandmortyapp.R
import com.example.rickandmortyapp.model.episodes_model.Result
import kotlinx.android.synthetic.main.item_episodes_layout.view.*

class EpisodesAdapter:RecyclerView.Adapter<EpisodesAdapter.EpisodesViewHolder>() {
    var listEpisodes = emptyList<com.example.rickandmortyapp.model.episodes_model.Result>()

    class EpisodesViewHolder(view: View): RecyclerView.ViewHolder(view)



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EpisodesViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_episodes_layout, parent, false)
        return EpisodesViewHolder(view)
    }

    override fun onBindViewHolder(holder: EpisodesViewHolder, position: Int) {

        holder.itemView.episode_name_item.text = listEpisodes[position].name
        holder.itemView.air_date_item.text = listEpisodes[position].air_date
        holder.itemView.season_item.text = listEpisodes[position].episode[2].toString()
        holder.itemView.number_item.text = "${listEpisodes[position].episode[4]}${listEpisodes[position].episode[5]}"
   }

    override fun getItemCount(): Int {
        return listEpisodes.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setList(list: List<Result>){
        listEpisodes=list
        notifyDataSetChanged()
    }
}