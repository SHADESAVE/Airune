package com.example.airplan.home.data.network

import com.example.airplan.home.data.model.TicketsResponseModel
import io.reactivex.Single
import retrofit2.Response
import retrofit2.http.*

interface TicketsApi {

    @FormUrlEncoded
    @POST("apiservices/pricing/v1.0/")
    fun getSessionKey(
        @Field("cabinclass") cabinClass: String,
        @Field("country") country: String,
        @Field("currency") currency: String,
        @Field("locale") locale: String,
        @Field("locationSchema") locationSchema: String,
        @Field("originplace") originPlace: String,
        @Field("destinationplace") destinationPlace: String,
        @Field("outbounddate") outboundDate: String,
        @Field("inbounddate") inboundDate: String,
        @Field("adults") adults: Int,
        @Field("children") children: Int,
        @Field("infants") infants: Int,
        @Field("apikey") apiKey: String,
    ): Single<Response<Unit>>

    @GET
    fun getTickets(@Url url: String): Single<TicketsResponseModel>
}