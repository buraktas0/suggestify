package com.burak.suggestify.data.local.mapper

import com.burak.suggestify.data.local.model.ArtistEntity
import com.burak.suggestify.domain.model.artist.response.Artist

class ArtistMapper : BaseMapper<ArtistEntity, Artist> {

    override fun mapToModel(entity: ArtistEntity): Artist {
        TODO("Not yet implemented")
    }

    override fun mapToModel(entityList: List<ArtistEntity>): List<Artist> {
        TODO("Not yet implemented")
    }

    override fun mapToEntity(model: Artist): ArtistEntity {
        TODO("Not yet implemented")
    }

    override fun mapToEntity(model: List<Artist>): List<ArtistEntity> {
        TODO("Not yet implemented")
    }
}