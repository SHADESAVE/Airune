package com.example.airplan.home.domain.usecase

import com.example.airplan.home.data.model.TicketsSessionModel
import com.example.airplan.home.domain.repository.TicketsRepository
import io.reactivex.Single
import retrofit2.Response
import javax.inject.Inject

class GetSessionKeyUseCase @Inject constructor(private val ticketsRepository: TicketsRepository) {

    operator fun invoke(sessionModel: TicketsSessionModel): Single<Response<Unit>> =
        ticketsRepository.getSessionKey(sessionModel)
}