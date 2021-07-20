package com.example.airplan.home.data.network

import com.example.airplan.home.domain.entity.Destination
import io.reactivex.Single
import retrofit2.http.GET

interface HotelsApi {

    @GET("region/europe")
    fun getHotels(): Single<List<Destination>>
}