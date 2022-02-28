package com.burak.suggestify.domain.usecase

import kotlinx.coroutines.flow.Flow

public abstract class BaseUseCase<in ReqParams, out Response> {

    abstract fun execute(params: ReqParams): Flow<Response>
}