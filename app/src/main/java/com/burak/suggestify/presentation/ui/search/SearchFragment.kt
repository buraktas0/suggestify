package com.burak.suggestify.presentation.ui.search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.burak.suggestify.databinding.FragmentSearchBinding
import com.burak.suggestify.presentation.ui.artists.ArtistAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SearchFragment : Fragment() {

    private lateinit var viewModel: SearchViewModel
    private lateinit var binding: FragmentSearchBinding
    private val navController by lazy { NavHostFragment.findNavController(this) }
    private var adapter: FavoriteArtistAdapter? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)

        binding = FragmentSearchBinding.inflate(layoutInflater)
        viewModel = ViewModelProvider(this)[SearchViewModel::class.java]

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        init()
        observe()
        viewModel.load()
    }

    private fun init() {
        binding.searchButton.setOnClickListener {
            handleAction()
        }
        val recyclerView = binding.recyclerViewFavorites
        recyclerView.layoutManager = LinearLayoutManager(context).apply {
            this.orientation = LinearLayoutManager.HORIZONTAL
        }
        adapter = FavoriteArtistAdapter(viewModel)
        recyclerView.adapter = adapter
    }

    private fun observe() {
        viewModel.favoriteArtistsLiveData.observe(viewLifecycleOwner, Observer {
            adapter?.setItems(it)
        })
    }

    private fun handleAction() {
        binding.inputArtist.text?.toString()?.takeIf { it.isNotEmpty() }?.let { artist: String ->
            binding.inputTrack.text?.toString()?.takeIf { it.isNotEmpty() }?.let { track: String ->
                navController.navigate(
                    SearchFragmentDirections.actionSearchFragmentToTrackFragment(
                        artist,
                        track
                    )
                )
            } ?: navController.navigate(
                SearchFragmentDirections.actionSearchFragmentToArtistFragment(
                    artist
                )
            )
        }
    }
}