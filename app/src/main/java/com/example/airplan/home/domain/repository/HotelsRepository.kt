package com.example.airplan.home.domain.repository

import com.example.airplan.home.domain.entity.Destination
import io.reactivex.Single

interface HotelsRepository{

    fun getHotels(): Single<List<Destination>>
}