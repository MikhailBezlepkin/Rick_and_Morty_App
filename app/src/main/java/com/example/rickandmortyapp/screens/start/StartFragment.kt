package com.example.rickandmortyapp.screens.start

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.example.rickandmortyapp.R


import com.example.rickandmortyapp.databinding.FragmentStartBinding

class StartFragment : Fragment() {


    private var _binding: FragmentStartBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentStartBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonLocations.setOnClickListener {
            binding.buttonLocations.setBackgroundColor(Color.RED)
            Navigation.findNavController(view)
                .navigate(R.id.action_startFragment_to_locationsFragment)

        }

        binding.buttonCharacters.setOnClickListener{
            binding.buttonCharacters.setBackgroundColor(Color.RED)
            Navigation.findNavController(view)
                .navigate(R.id.action_startFragment_to_charactersFragment)

        }

        binding.buttonEpisodes.setOnClickListener{
            binding.buttonEpisodes.setBackgroundColor(Color.RED)
            Navigation.findNavController(view)
                .navigate(R.id.action_startFragment_to_episodesFragment)

        }
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}