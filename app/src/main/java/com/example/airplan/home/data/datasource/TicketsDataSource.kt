package com.example.airplan.home.data.datasource

import com.example.airplan.home.data.model.Agent
import com.example.airplan.home.data.model.TicketsResponseModel
import com.example.airplan.home.data.model.TicketsSessionModel
import com.example.airplan.home.data.network.TicketsApi
import com.example.airplan.home.domain.entity.Destination
import io.reactivex.Single
import retrofit2.Response
import javax.inject.Inject

interface TicketsDataSource {

    fun getSessionKey(sessionModel: TicketsSessionModel): Single<Response<Unit>>

    fun getTickets(sessionKey: String): Single<TicketsResponseModel>

    fun getTicketsFromLocal(): Single<List<Destination>>
}

class TicketsDataSourceImpl @Inject constructor(
    private val ticketsApi: TicketsApi
) : TicketsDataSource {

    override fun getSessionKey(sessionModel: TicketsSessionModel): Single<Response<Unit>> =
        ticketsApi.getSessionKey(
            sessionModel.cabinClass,
            sessionModel.country,
            sessionModel.currency,
            sessionModel.locale,
            sessionModel.locationSchema,
            sessionModel.originPlace,
            sessionModel.destinationPlace,
            sessionModel.outboundDate,
            sessionModel.inboundDate,
            sessionModel.adults,
            sessionModel.children,
            sessionModel.infants,
            sessionModel.apiKey
        )

    override fun getTickets(sessionKey: String): Single<TicketsResponseModel> {
        val url = "apiservices/pricing/uk2/v1.0/$sessionKey?apikey=prtl6749387986743898559646983194"
        return ticketsApi.getTickets(url)
    }

    override fun getTicketsFromLocal(): Single<List<Destination>> =
        Single.just(
            listOf(
                Destination(
                    agent = pobeda,
                    name = "Москва Внуково",
                    departure = "06:50",
                    arrival = "08:20",
                    price = 1999.00,
                    currencySymbol = "₽",
                    description = "1 час 30 минут",
                    deeplink = ""
                ),
                Destination(
                    agent = pobeda,
                    name = "Москва Внуково",
                    departure = "09:40",
                    arrival = "11:10",
                    price = 1999.00,
                    currencySymbol = "₽",
                    description = "1 час 30 минут",
                    deeplink = ""
                ),
                Destination(
                    agent = pobeda,
                    name = "Москва Внуково",
                    departure = "17:50",
                    arrival = "19:20",
                    price = 1999.00,
                    currencySymbol = "₽",
                    description = "1 час 30 минут",
                    deeplink = ""
                ),
                Destination(
                    agent = pobeda,
                    name = "Москва Внуково",
                    departure = "18:30",
                    arrival = "20:00",
                    price = 1999.00,
                    currencySymbol = "₽",
                    description = "1 час 30 минут",
                    deeplink = ""
                ),
                Destination(
                    agent = pobeda,
                    name = "Москва Шереметьево",
                    departure = "21:35",
                    arrival = "23:10",
                    price = 1999.00,
                    currencySymbol = "₽",
                    description = "1 час 35 минут",
                    deeplink = ""
                ),
                Destination(
                    agent = ural,
                    name = "Москва Домодедово",
                    departure = "14:20",
                    arrival = "15:50",
                    price = 2091.00,
                    currencySymbol = "₽",
                    description = "1 час 30 минут",
                    deeplink = ""
                ),
                Destination(
                    agent = nordwind,
                    name = "Москва Шереметьево",
                    departure = "14:20",
                    arrival = "15:50",
                    price = 2312.00,
                    currencySymbol = "₽",
                    description = "1 час 10 минут",
                    deeplink = ""
                ),
                Destination(
                    agent = pobeda,
                    name = "Москва Внуково",
                    departure = "07:35",
                    arrival = "09:05",
                    price = 2349.00,
                    currencySymbol = "₽",
                    description = "1 час 30 минут",
                    deeplink = ""
                ),
                Destination(
                    agent = pobeda,
                    name = "Москва Внуково",
                    departure = "20:15",
                    arrival = "21:45",
                    price = 2349.00,
                    currencySymbol = "₽",
                    description = "1 час 30 минут",
                    deeplink = ""
                ),
                Destination(
                    agent = utair,
                    name = "Москва Внуково",
                    departure = "12:55",
                    arrival = "14:20",
                    price = 2425.00,
                    currencySymbol = "₽",
                    description = "1 час 25 минут",
                    deeplink = ""
                ),
                Destination(
                    agent = utair,
                    name = "Москва Внуково",
                    departure = "20:30",
                    arrival = "22:10",
                    price = 2425.00,
                    currencySymbol = "₽",
                    description = "1 час 40 минут",
                    deeplink = ""
                ),
                Destination(
                    agent = sseven,
                    name = "Москва Домодедово",
                    departure = "05:20",
                    arrival = "06:50",
                    price = 2546.00,
                    currencySymbol = "₽",
                    description = "1 час 30 минут",
                    deeplink = ""
                ),
                Destination(
                    agent = sseven,
                    name = "Москва Домодедово",
                    departure = "12:20",
                    arrival = "13:50",
                    price = 2546.00,
                    currencySymbol = "₽",
                    description = "1 час 30 минут",
                    deeplink = ""
                ),
                Destination(
                    agent = sseven,
                    name = "Москва Домодедово",
                    departure = "15:20",
                    arrival = "16:50",
                    price = 2546.00,
                    currencySymbol = "₽",
                    description = "1 час 30 минут",
                    deeplink = ""
                ),
                Destination(
                    agent = sseven,
                    name = "Москва Домодедово",
                    departure = "17:10",
                    arrival = "18:40",
                    price = 2561.00,
                    currencySymbol = "₽",
                    description = "1 час 30 минут",
                    deeplink = ""
                ),
                Destination(
                    agent = ural,
                    name = "Москва Домодедово",
                    departure = "16:00",
                    arrival = "17:30",
                    price = 2710.00,
                    currencySymbol = "₽",
                    description = "1 час 30 минут",
                    deeplink = ""
                ),
                Destination(
                    agent = aeroflot,
                    name = "Москва Внуково",
                    departure = "06:05",
                    arrival = "07:35",
                    price = 2710.00,
                    currencySymbol = "₽",
                    description = "1 час 30 минут",
                    deeplink = ""
                ),
                Destination(
                    agent = aeroflot,
                    name = "Москва Внуково",
                    departure = "08:05",
                    arrival = "09:35",
                    price = 2710.00,
                    currencySymbol = "₽",
                    description = "1 час 30 минут",
                    deeplink = ""
                ),
                Destination(
                    agent = aeroflot,
                    name = "Москва Внуково",
                    departure = "09:05",
                    arrival = "10:35",
                    price = 2710.00,
                    currencySymbol = "₽",
                    description = "1 час 30 минут",
                    deeplink = ""
                ),
                Destination(
                    agent = aeroflot,
                    name = "Москва Внуково",
                    departure = "11:40",
                    arrival = "13:10",
                    price = 2710.00,
                    currencySymbol = "₽",
                    description = "1 час 30 минут",
                    deeplink = ""
                ),
                Destination(
                    agent = aeroflot,
                    name = "Москва Внуково",
                    departure = "14:15",
                    arrival = "15:45",
                    price = 2710.00,
                    currencySymbol = "₽",
                    description = "1 час 30 минут",
                    deeplink = ""
                ),
                Destination(
                    agent = aeroflot,
                    name = "Москва Внуково",
                    departure = "15:35",
                    arrival = "17:05",
                    price = 2710.00,
                    currencySymbol = "₽",
                    description = "1 час 30 минут",
                    deeplink = ""
                ),
                Destination(
                    agent = aeroflot,
                    name = "Москва Внуково",
                    departure = "17:45",
                    arrival = "19:15",
                    price = 2710.00,
                    currencySymbol = "₽",
                    description = "1 час 30 минут",
                    deeplink = ""
                ),
                Destination(
                    agent = aeroflot,
                    name = "Москва Внуково",
                    departure = "19:15",
                    arrival = "20:45",
                    price = 2710.00,
                    currencySymbol = "₽",
                    description = "1 час 30 минут",
                    deeplink = ""
                ),
                Destination(
                    agent = aeroflot,
                    name = "Москва Внуково",
                    departure = "20:00",
                    arrival = "21:30",
                    price = 2710.00,
                    currencySymbol = "₽",
                    description = "1 час 30 минут",
                    deeplink = ""
                ),
                Destination(
                    agent = aeroflot,
                    name = "Москва Внуково",
                    departure = "22:50",
                    arrival = "00:35",
                    price = 2710.00,
                    currencySymbol = "₽",
                    description = "1 час 30 минут",
                    deeplink = ""
                ),
            )
        )

    private val pobeda = Agent(
        id = 1,
        name = "Pobeda",
        imageUrl = "https://s1.apideeplink.com/images/websites/pobe.png",
        status = "UpdatesComplete",
        optimisedForMobile = true,
        type = "AirLine"
    )

    private val ural = Agent(
        id = 2,
        name = "Ural Airlines",
        imageUrl = "https://s1.apideeplink.com/images/airlines/U6.png",
        status = "UpdatesComplete",
        optimisedForMobile = true,
        type = "AirLine"
    )

    private val nordwind = Agent(
        id = 3,
        name = "Nordwind Airlines",
        imageUrl = "https://s1.apideeplink.com/images/airlines/NW.png",
        status = "UpdatesComplete",
        optimisedForMobile = true,
        type = "AirLine"
    )

    private val utair = Agent(
        id = 4,
        name = "Utair",
        imageUrl = "https://s1.apideeplink.com/images/airlines/UT.png",
        status = "UpdatesComplete",
        optimisedForMobile = true,
        type = "AirLine"
    )

    private val sseven = Agent(
        id = 5,
        name = "S7 Airlines",
        imageUrl = "https://s1.apideeplink.com/images/websites/ssev.png",
        status = "UpdatesComplete",
        optimisedForMobile = true,
        type = "AirLine"
    )

    private val aeroflot = Agent(
        id = 6,
        name = "Aeroflot",
        imageUrl = "https://s1.apideeplink.com/images/websites/flot.png",
        status = "UpdatesComplete",
        optimisedForMobile = true,
        type = "AirLine"
    )
}