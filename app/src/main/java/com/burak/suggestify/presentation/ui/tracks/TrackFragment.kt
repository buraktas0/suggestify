package com.burak.suggestify.presentation.ui.tracks

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.burak.suggestify.databinding.FragmentTrackBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TrackFragment : Fragment() {

    private lateinit var viewModel: TrackViewModel
    private lateinit var binding: FragmentTrackBinding
    private val args: TrackFragmentArgs by navArgs()
    private var adapter: TrackAdapter? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)

        binding = FragmentTrackBinding.inflate(layoutInflater)
        viewModel = ViewModelProvider(this)[TrackViewModel::class.java]

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        init()
        observe()
        viewModel.search(args.artistName, args.trackName)
    }

    private fun init() {
        val recyclerView = binding.recyclerViewTracks
        recyclerView.layoutManager = LinearLayoutManager(context).apply {
            this.orientation = LinearLayoutManager.VERTICAL
        }
        adapter = TrackAdapter()
        recyclerView.adapter = adapter
    }

    private fun observe() {
        viewModel.similarTracksLiveData.observe(viewLifecycleOwner, Observer {
            adapter?.setItems(it.similarTracks.trackList)
        })
    }
}