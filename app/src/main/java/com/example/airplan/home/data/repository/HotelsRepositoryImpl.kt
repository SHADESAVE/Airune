package com.example.airplan.home.data.repository

import com.example.airplan.home.data.datasource.HotelsDataSource
import com.example.airplan.home.domain.entity.Destination
import com.example.airplan.home.domain.repository.HotelsRepository
import io.reactivex.Single
import javax.inject.Inject

class HotelsRepositoryImpl @Inject constructor(private val hotelsDataSource: HotelsDataSource) : HotelsRepository {

    override fun getHotels(): Single<List<Destination>> =
        hotelsDataSource.getHotelsFromLocal()
}