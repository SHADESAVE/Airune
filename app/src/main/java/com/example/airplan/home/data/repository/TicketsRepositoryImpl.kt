package com.example.airplan.home.data.repository

import com.example.airplan.home.data.converter.TicketsResponseModelConverter
import com.example.airplan.home.data.datasource.TicketsDataSource
import com.example.airplan.home.data.model.TicketsSessionModel
import com.example.airplan.home.domain.entity.Destination
import com.example.airplan.home.domain.repository.TicketsRepository
import io.reactivex.Single
import retrofit2.Response
import javax.inject.Inject

class TicketsRepositoryImpl @Inject constructor(
    private val ticketsDataSource: TicketsDataSource,
    private val ticketsResponseModelConverter: TicketsResponseModelConverter,
) : TicketsRepository {

    override fun getSessionKey(sessionModel: TicketsSessionModel): Single<Response<Unit>> =
        ticketsDataSource.getSessionKey(sessionModel)

    override fun getTickets(sessionKey: String): Single<List<Destination>> =
        ticketsDataSource.getTicketsFromLocal()
//        ticketsDataSource.getTickets(sessionKey).map(ticketsResponseModelConverter::convert)
}