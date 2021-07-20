package com.example.airplan.home.data.datasource

import com.example.airplan.home.data.model.Agent
import com.example.airplan.home.data.network.HotelsApi
import com.example.airplan.home.domain.entity.Destination
import io.reactivex.Single
import javax.inject.Inject

interface HotelsDataSource {

    fun getHotels(): Single<List<Destination>>

    fun getHotelsFromLocal(): Single<List<Destination>>
}

class HotelsDataSourceImpl @Inject constructor(private val hotelsApi: HotelsApi) :
    HotelsDataSource {

    override fun getHotels(): Single<List<Destination>> =
        hotelsApi.getHotels()

    override fun getHotelsFromLocal(): Single<List<Destination>> =
        Single.just(
            listOf(
                Destination(
                    agent = booking,
                    name = "Мини-отель «Тарлеон» ★★",
                    departure = "Авиамоторная, 44, Москва",
                    arrival = "",
                    price = 566.00,
                    currencySymbol = "₽ за ночь",
                    description = "Итого: 7920.00₽",
                    deeplink = ""
                ),
                Destination(
                    agent = agoda,
                    name = "Пекарня и отель «Круассан» ★★",
                    departure = "Космодамианская набережная, 40/42, Москва",
                    arrival = "",
                    price = 576.00,
                    currencySymbol = "₽ за ночь",
                    description = "Итого: 8064.00₽",
                    deeplink = ""
                ),
                Destination(
                    agent = booking,
                    name = "Гостиница Султан 5 на Белорусской ★★",
                    departure = "Скаковая, 36, Москва",
                    arrival = "",
                    price = 593.00,
                    currencySymbol = "₽ за ночь",
                    description = "Итого: 8295.00₽",
                    deeplink = ""
                ),
                Destination(
                    agent = booking,
                    name = "Отель «Отдых 2» ★",
                    departure = "Совхозная, 27, Москва",
                    arrival = "",
                    price = 700.00,
                    currencySymbol = "₽ за ночь",
                    description = "Итого: 9800.00₽",
                    deeplink = ""
                ),
            )
        )

    private val agoda = Agent(
        id = 1,
        name = "Adoga",
        imageUrl = "https://logos.skyscnr.com/images/websites/bar/h_ad.png",
        status = "UpdatesComplete",
        optimisedForMobile = true,
        type = "Hotel"
    )

    private val booking = Agent(
        id = 1,
        name = "Booking.com",
        imageUrl = "https://logos.skyscnr.com/images/websites/bar/h_bc.png",
        status = "UpdatesComplete",
        optimisedForMobile = true,
        type = "Hotel"
    )
}