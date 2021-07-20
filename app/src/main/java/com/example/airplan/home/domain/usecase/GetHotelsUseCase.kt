package com.example.airplan.home.domain.usecase

import com.example.airplan.home.domain.entity.Destination
import com.example.airplan.home.domain.repository.HotelsRepository
import io.reactivex.Single
import javax.inject.Inject

class GetHotelsUseCase @Inject constructor(private val hotelsRepository: HotelsRepository) {

    operator fun invoke(): Single<List<Destination>> =
        hotelsRepository.getHotels()
}

