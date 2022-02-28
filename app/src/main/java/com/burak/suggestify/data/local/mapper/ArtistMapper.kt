package com.burak.suggestify.data.local.mapper

import com.burak.suggestify.data.local.model.ArtistEntity
import com.burak.suggestify.domain.model.favorite.FavoriteArtist
import javax.inject.Inject

class ArtistMapper @Inject constructor() : BaseMapper<ArtistEntity, FavoriteArtist> {

    override fun mapToModel(entity: ArtistEntity): FavoriteArtist {
        return FavoriteArtist(
            name = entity.name,
            image = entity.image,
            url = entity.url,
            time = entity.time
        )
    }

    override fun mapToEntity(model: FavoriteArtist): ArtistEntity {
        return ArtistEntity(
            name = model.name,
            image = model.image,
            url = model.url,
            time = model.time
        )
    }
}