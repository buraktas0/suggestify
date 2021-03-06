package com.burak.suggestify.presentation.ui.artists

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.burak.suggestify.databinding.FragmentArtistBinding
import com.burak.suggestify.presentation.ui.search.SearchViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ArtistFragment : Fragment() {

    private lateinit var viewModel: ArtistViewModel
    private lateinit var binding: FragmentArtistBinding
    private val args: ArtistFragmentArgs by navArgs()
    private var adapter: ArtistAdapter? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)

        binding = FragmentArtistBinding.inflate(layoutInflater)
        viewModel = ViewModelProvider(this)[ArtistViewModel::class.java]

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
        recyclerView.layoutManager = LinearLayoutManager(context).apply {
            this.orientation = LinearLayoutManager.VERTICAL
        }
        adapter = ArtistAdapter(viewModel)
        recyclerView.adapter = adapter
    }

    private fun observe() {
        viewModel.similarArtistsLiveData.observe(viewLifecycleOwner, Observer {
            adapter?.setItems(it.similarArtists.artistList)
        })
    }
}