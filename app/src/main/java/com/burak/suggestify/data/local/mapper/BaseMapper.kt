package com.burak.suggestify.data.local.mapper

interface BaseMapper<DataModel, DomainModel> {

    fun mapToModel(entity: DataModel): DomainModel

    fun mapToEntity(model: DomainModel): DataModel



}