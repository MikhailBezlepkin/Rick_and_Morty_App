package com.example.rickandmortyapp.screens.characters

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.rickandmortyapp.R
import com.example.rickandmortyapp.databinding.FragmentCharactersBinding


class CharactersFragment : Fragment() {

lateinit var recyclerView: RecyclerView
lateinit var adapter: CharactersAdapter


    private var _binding: FragmentCharactersBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCharactersBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        binding.buttonBack.setOnClickListener {
            Navigation.findNavController(view)
                .navigate(R.id.action_charactersFragment_to_startFragment)
        }
        val viewModel = ViewModelProvider(this).get(CharactersViewModel::class.java)
        recyclerView = binding.rvCharacters
        adapter = CharactersAdapter()
        recyclerView.adapter = adapter
        viewModel.getCharVM()
        viewModel.myCharactersList.observe(viewLifecycleOwner
        ) { list ->
            adapter.setList(list)
        }

        binding.buttonFindCharacter.setOnClickListener {
            val list = viewModel.myCharactersList.value ?: emptyList()
            val sortedList = list.filter { result ->
                result.name.contains(binding.editTextFindCharacters.text.toString())
            }
            adapter.setList(sortedList)
        }


    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    }