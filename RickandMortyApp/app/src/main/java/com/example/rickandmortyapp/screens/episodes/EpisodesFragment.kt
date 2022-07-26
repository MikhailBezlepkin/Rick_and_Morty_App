package com.example.rickandmortyapp.screens.episodes

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.rickandmortyapp.R
import com.example.rickandmortyapp.databinding.FragmentEpisodesBinding


class EpisodesFragment : Fragment() {
    private var _binding: FragmentEpisodesBinding? = null
    private val binding get() = _binding!!

    lateinit var recyclerView: RecyclerView
    lateinit var adapter: EpisodesAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentEpisodesBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val viewModel = ViewModelProvider(this).get(EpisodesViewModel::class.java)
        binding.buttonBack.setOnClickListener {
            Navigation.findNavController(view)
                .navigate(R.id.action_episodesFragment_to_startFragment)
        }

        recyclerView = binding.rvEpisodes
        adapter = EpisodesAdapter()
        recyclerView.adapter = adapter
        viewModel.getEpVM()
        viewModel.myEpisodesList.observe(viewLifecycleOwner
        ) { list ->
            adapter.setList(list)
        }

        binding.buttonFindEpisode.setOnClickListener {
            val list = viewModel.myEpisodesList.value ?: emptyList()
            val sortedList = list.filter { result->
                result.name.contains(binding.editTextFindEpisodes.text.toString())
            }
            adapter.setList(sortedList)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}