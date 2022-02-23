package com.burak.suggestify.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.burak.suggestify.R
import com.burak.suggestify.databinding.ActivityMainBinding
import com.burak.suggestify.domain.model.request.ArtistRequest
import com.burak.suggestify.domain.model.request.TrackRequest
import com.burak.suggestify.presentation.ui.MainViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        bind()
        observe()
    }

    private fun bind() {
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        binding.searchButton.setOnClickListener {
            search()
        }
    }

    private fun observe() {
        viewModel.similarArtistsLiveData.observe(this, Observer {

        })

        viewModel.similarTracksLiveData.observe(this, Observer {
            
        })
    }

    private fun search() {
        binding.inputArtist.text?.toString()?.let { artist: String ->
            {
                binding.inputTrack.text?.toString()?.let { track: String ->
                    {
                        searchTrack(artist, track)
                    }
                } ?: searchArtist(artist)
            }
        }
    }

    private fun searchTrack(artist: String, track: String) {
        viewModel.getSimilarTracks(
            request = TrackRequest(
                artist = artist,
                track = track,
                autoCorrect = 1,
                limit = null,
                mbid = null
            )
        )
    }

    private fun searchArtist(artist: String) {
        viewModel.getSimilarArtists(
            request = ArtistRequest(
                artist = artist,
                autoCorrect = 1,
                limit = null,
                mbid = null
            )
        )
    }
}