package com.example.airplan.home.data.model

data class TicketsSessionModel(
    val cabinClass: String,
    val country: String,
    val currency: String,
    val locale: String,
    val locationSchema: String,
    val originPlace: String,
    val destinationPlace: String,
    val outboundDate: String,
    val inboundDate: String,
    val adults: Int,
    val children: Int,
    val infants: Int,
    val apiKey: String,
) {
    companion object {

        val BASE: TicketsSessionModel = TicketsSessionModel(
            cabinClass = "economy",
            country = "RU",
            currency = "RUB",
            locale = "ru-RU",
            locationSchema = "iata",
            originPlace = "MOW",
            destinationPlace = "OVB",
            outboundDate = "2021-07-07",
            inboundDate = "",
            adults = 1,
            children = 0,
            infants = 0,
            apiKey = "prtl6749387986743898559646983194"
        )
    }
}