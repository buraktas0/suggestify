package com.burak.suggestify.data.local.mapper

interface BaseMapper<DataModel, DomainModel> {

    fun mapToModel(entity: DataModel): DomainModel

    fun mapToModel(entityList: List<DataModel>): List<DomainModel>

    fun mapToEntity(model: DomainModel): DataModel

    fun mapToEntity(model: List<DomainModel>): List<DataModel>


}