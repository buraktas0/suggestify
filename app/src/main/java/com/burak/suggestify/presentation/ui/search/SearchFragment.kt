package com.burak.suggestify.presentation.ui.search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.burak.suggestify.databinding.FragmentSearchBinding

class SearchFragment : Fragment() {

    private lateinit var viewModel: SearchViewModel
    private lateinit var binding: FragmentSearchBinding
    private val navController = findNavController()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)

        binding = FragmentSearchBinding.inflate(layoutInflater)
        viewModel = ViewModelProvider(this).get(SearchViewModel::class.java)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        init()
    }

    private fun init() {
        binding.searchButton.setOnClickListener {
            handleAction()
        }
    }

    private fun handleAction() {
        binding.inputArtist.text?.toString()?.let { artist: String ->
            binding.inputTrack.text?.toString()?.let { track: String ->
                navController.navigate(SearchFragmentDirections.actionSearchFragmentToTrackFragment(artist, track))
            } ?: navController.navigate(SearchFragmentDirections.actionSearchFragmentToArtistFragment(artist))
        }

    }

}