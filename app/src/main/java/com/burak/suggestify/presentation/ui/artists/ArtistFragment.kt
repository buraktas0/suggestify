package com.burak.suggestify.presentation.ui.artists

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.burak.suggestify.databinding.FragmentArtistBinding
import com.burak.suggestify.presentation.ui.search.SearchViewModel

class ArtistFragment : Fragment() {

    private lateinit var viewModel: ArtistViewModel
    private lateinit var binding: FragmentArtistBinding
    private val args: ArtistFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)

        binding = FragmentArtistBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        init()
        observe()
        viewModel.search(args.artistName)
    }

    private fun init() {
        val recyclerView = binding.recyclerViewArtists
        val adapter = ArtistAdapter(emptyList())
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(context).apply {
            this.orientation = LinearLayoutManager.VERTICAL
        }
    }

    private fun observe() {
        viewModel.similarArtistsLiveData.observe(viewLifecycleOwner, Observer {

        })
    }
}