package com.example.rickandmortyapp.screens.locations

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.rickandmortyapp.R
import com.example.rickandmortyapp.databinding.FragmentLocationsBinding
import com.example.rickandmortyapp.screens.episodes.EpisodesAdapter
import com.example.rickandmortyapp.screens.episodes.EpisodesViewModel
import kotlinx.android.synthetic.main.fragment_episodes.view.*
import kotlinx.android.synthetic.main.fragment_locations.*


class LocationsFragment : Fragment() {

    lateinit var recyclerView: RecyclerView
    lateinit var adapter: LocationsAdapter
    private var _binding: FragmentLocationsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLocationsBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val viewModel = ViewModelProvider(this).get(LocationsVievModel::class.java)
        binding.buttonBack.setOnClickListener {
            Navigation.findNavController(view)
                .navigate(R.id.action_locationsFragment_to_startFragment)

        }

        recyclerView = binding.rvLocations
        adapter = LocationsAdapter()
        recyclerView.adapter = adapter
        viewModel.getLocVM()
        viewModel.myLocationsList.observe(viewLifecycleOwner
        ) { list ->
            adapter.setList(list)
        }

    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}