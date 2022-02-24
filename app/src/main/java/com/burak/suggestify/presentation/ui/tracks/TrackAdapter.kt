package com.burak.suggestify.presentation.ui.tracks

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.burak.suggestify.R
import com.burak.suggestify.databinding.CardTrackBinding
import com.burak.suggestify.domain.model.response.similarTracks.Track

class TrackAdapter(
    private val tracks: List<Track>
) : RecyclerView.Adapter<TrackAdapter.TrackViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TrackViewHolder {
        val view = CardTrackBinding.inflate(LayoutInflater.from(parent.context))
        return TrackViewHolder(view)
    }

    override fun onBindViewHolder(holder: TrackViewHolder, position: Int) {
        holder.bind(tracks[position])
    }

    override fun getItemCount(): Int {
        return tracks.size
    }

    class TrackViewHolder(private val binding: CardTrackBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(track: Track) {
            binding.apply {
                trackCardTitle.text = track.name
                trackMatchText.text =
                    binding.root.context.getString(R.string.text_match).plus((track.match * 100))
            }
        }
    }
}