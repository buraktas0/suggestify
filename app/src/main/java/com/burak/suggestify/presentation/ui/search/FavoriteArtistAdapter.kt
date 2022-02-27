package com.burak.suggestify.presentation.ui.search

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.burak.suggestify.databinding.CardFavoriteBinding
import com.burak.suggestify.domain.model.artist.response.Artist
import com.burak.suggestify.domain.model.favorite.FavoriteArtist
import com.burak.suggestify.util.GlideApp

class FavoriteArtistAdapter(val viewModel: SearchViewModel) :
    RecyclerView.Adapter<FavoriteArtistAdapter.FavoriteArtistViewHolder>() {

    private var favoriteArtists = emptyList<FavoriteArtist>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavoriteArtistViewHolder {
        val view = CardFavoriteBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return FavoriteArtistViewHolder(view)
    }

    override fun onBindViewHolder(holder: FavoriteArtistViewHolder, position: Int) {
        holder.bind(favoriteArtists[position])
        holder.binding.deleteFavorite.setOnClickListener {
            viewModel.delete(favoriteArtists[position])
        }
    }

    override fun getItemCount(): Int {
        return favoriteArtists.size
    }

    class FavoriteArtistViewHolder(val binding: CardFavoriteBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(artist: FavoriteArtist) {
            binding.apply {
                favoriteCardTitle.text = artist.name
                GlideApp.with(binding.root.context)
                    .load(artist.image)
                    .into(favoriteImage)
            }
        }
    }

    fun setItems(favoriteArtists: List<FavoriteArtist>) {
        this.favoriteArtists = favoriteArtists
        notifyDataSetChanged()
    }
}