package com.burak.suggestify.presentation.ui.artists

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.burak.suggestify.R
import com.burak.suggestify.databinding.CardArtistBinding
import com.burak.suggestify.domain.model.artist.response.Artist
import com.burak.suggestify.util.GlideApp
import com.burak.suggestify.util.toPercentage

class ArtistAdapter(val viewModel: ArtistViewModel) :
    RecyclerView.Adapter<ArtistAdapter.ArtistViewHolder>() {

    private var artists = emptyList<Artist>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArtistViewHolder {
        val view = CardArtistBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ArtistViewHolder(view)
    }

    override fun onBindViewHolder(holder: ArtistViewHolder, position: Int) {
        holder.bind(artists[position])
        holder.binding.favoriteArtist.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) viewModel.saveArtist(artists[position])
        }
    }

    override fun getItemCount(): Int {
        return artists.size
    }

    class ArtistViewHolder(val binding: CardArtistBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(artist: Artist) {
            binding.apply {
                artistCardTitle.text = artist.name
                artistMatchText.text =
                    binding.root.context.getString(R.string.text_match)
                        .plus((artist.match.toPercentage()))
                GlideApp.with(binding.root.context)
                    .load(artist.image[0].text)
                    .into(artistImage)
            }
        }
    }

    fun setItems(artists: List<Artist>) {
        this.artists = artists
        notifyDataSetChanged()
    }
}