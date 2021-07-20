package com.example.airplan.home.domain.usecase

import com.example.airplan.home.data.model.TicketsSessionModel
import com.example.airplan.home.domain.entity.Destination
import com.example.airplan.home.domain.repository.TicketsRepository
import com.example.airplan.home.presentation.HEADER
import io.reactivex.Single
import javax.inject.Inject

class GetTicketsUseCase @Inject constructor(
    private val getSessionKeyUseCase: GetSessionKeyUseCase,
    private val ticketsRepository: TicketsRepository
) {

    operator fun invoke(sessionModel: TicketsSessionModel): Single<List<Destination>> =
        getSessionKeyUseCase(sessionModel).flatMap { response ->
            response.headers()[HEADER]?.let { location ->
                val sessionKey = Regex("""[^/]+/?$""").find(location)?.value.orEmpty()
                ticketsRepository.getTickets(sessionKey)
            }
        }
}

