package com.burak.suggestify.data.local.mapper

import com.burak.suggestify.data.local.model.ArtistEntity
import com.burak.suggestify.data.local.model.TrackEntity
import com.burak.suggestify.domain.model.favorite.FavoriteArtist
import com.burak.suggestify.domain.model.favorite.FavoriteTrack

class TrackMapper : BaseMapper<TrackEntity, FavoriteTrack> {

    override fun mapToModel(entity: TrackEntity): FavoriteTrack {
        return FavoriteTrack(name = entity.name, artist = entity.artist, image = entity.image , url = entity.url, time = entity.time)
    }


    override fun mapToEntity(model: FavoriteTrack): TrackEntity {
        return TrackEntity(name = model.name, artist = model.artist, image = model.image, url = model.url, time = model.time)
    }

}