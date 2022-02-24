package com.burak.suggestify.presentation.ui.artists

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.burak.suggestify.R
import com.burak.suggestify.databinding.CardArtistBinding
import com.burak.suggestify.domain.model.response.similarArtists.Artist
import com.burak.suggestify.util.GlideApp
import com.burak.suggestify.util.toPercentage

class ArtistAdapter : RecyclerView.Adapter<ArtistAdapter.ArtistViewHolder>() {

    private var artists = emptyList<Artist>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArtistViewHolder {
        val view = CardArtistBinding.inflate(LayoutInflater.from(parent.context))
        return ArtistViewHolder(view)
    }

    override fun onBindViewHolder(holder: ArtistViewHolder, position: Int) {
        holder.bind(artists[position])
    }

    override fun getItemCount(): Int {
        return artists.size
    }

    class ArtistViewHolder(private val binding: CardArtistBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(artist: Artist) {
            binding.apply {
                artistCardTitle.text = artist.name
                artistMatchText.text =
                    binding.root.context.getString(R.string.text_match).plus((artist.match.toPercentage()))
                GlideApp.with(binding.root)
                    .load(artist.image[0])
                    .into(artistImage)
            }
        }
    }

    fun setItems(artists: List<Artist>) {
        this.artists = artists
    }
}