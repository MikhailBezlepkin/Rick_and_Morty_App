package com.example.rickandmortyapp.screens.characters


import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.rickandmortyapp.R
import com.example.rickandmortyapp.model.characters_model.CharactersItem
import kotlinx.android.synthetic.main.item_characters_layout.view.*

class CharactersAdapter : RecyclerView.Adapter<CharactersAdapter.CharactersViewHolder>() {

    var listCharacters = emptyList<CharactersItem>()

    class CharactersViewHolder(view: View) : RecyclerView.ViewHolder(view)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharactersViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_characters_layout, parent, false)
        return CharactersViewHolder(view)
    }

    override fun onBindViewHolder(holder: CharactersViewHolder, position: Int) {
        with(holder.itemView) {
            character_name_item.text = listCharacters[position].name
            gender_item.text = listCharacters[position].gender
            species_item.text = listCharacters[position].species
            location_item.text = listCharacters[position].location.name
            image_item.load(listCharacters[position].image)
        }


    }

    override fun getItemCount(): Int {
        return listCharacters.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setList(list: List<CharactersItem>) {
        listCharacters = list
        notifyDataSetChanged()
    }
}