package com.burak.suggestify.presentation.ui.tracks

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.burak.suggestify.R
import com.burak.suggestify.databinding.CardTrackBinding
import com.burak.suggestify.domain.model.track.response.Track
import com.burak.suggestify.util.GlideApp
import com.burak.suggestify.util.toPercentage

class TrackAdapter : RecyclerView.Adapter<TrackAdapter.TrackViewHolder>() {

    private var tracks = emptyList<Track>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TrackViewHolder {
        val view = CardTrackBinding.inflate(LayoutInflater.from(parent.context), parent, false)
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
                    binding.root.context.getString(R.string.text_match)
                        .plus((track.match.toPercentage()))
                GlideApp.with(binding.root)
                    .load(track.image[0].text)
                    .into(trackImage)
            }
        }
    }

    fun setItems(tracks: List<Track>) {
        this.tracks = tracks
        notifyDataSetChanged()
    }
}