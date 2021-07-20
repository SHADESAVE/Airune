package com.example.airplan.home.domain.repository

import com.example.airplan.home.data.model.TicketsResponseModel
import com.example.airplan.home.data.model.TicketsSessionModel
import com.example.airplan.home.domain.entity.Destination
import io.reactivex.Observable
import io.reactivex.Single
import retrofit2.Response

interface TicketsRepository {

    fun getSessionKey(sessionModel: TicketsSessionModel): Single<Response<Unit>>

    fun getTickets(sessionKey: String): Single<List<Destination>>
}