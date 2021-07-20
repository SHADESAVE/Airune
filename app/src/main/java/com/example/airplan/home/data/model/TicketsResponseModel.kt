package com.example.airplan.home.data.model

data class TicketsResponseModel(
    val sessionKey: String,
    val query: Query,
    val status: String,
    val itineraries: List<Itinerary>,
    val legs: List<Leg>,
    val segments: List<Segment>,
    val carriers: List<Carrier>,
    val agents: List<Agent>,
    val places: List<Place>,
    val currencies: List<Currency>,
)

data class Query(
    val country: String,
    val currency: String,
    val locale: String,
    val adults: Int,
    val children: Int,
    val infants: Int,
    val originPlace: String,
    val destinationPlace: String,
    val outboundDate: String,
    val inboundDate: String,
    val locationSchema: String,
    val cabinClass: String,
    val groupPricing: Boolean,
)

data class Itinerary(
    val outboundLegId: String,
    val inboundLegId: String,
    val pricingOptions: List<PricingOption>,
    val bookingDetailsLink: BookingDetailsLink,
)

data class PricingOption(
    val agents: List<Long>,
    val quoteAgeInMinutes: Int,
    val price: Double,
    val deeplinkUrl: String,
)

data class BookingDetailsLink(
    val uri: String,
    val body: String,
    val method: String,
)

data class Leg(
    val id: String,
    val segmentIds: List<Long>,
    val originStation: Long,
    val destinationStation: Long,
    val departure: String,
    val arrival: String,
    val duration: Int,
    val journeyMode: String,
    val stops: List<Long>,
    val carriers: List<Long>,
    val operatingCarriers: List<Long>,
    val directionality: String,
    val flightNumbers: List<FlightNumber>,
)

data class FlightNumber(
    val flightNumber: String,
    val carrierId: Long,
)

data class Segment(
    val id: Long,
    val originStation: Long,
    val destinationStation: Long,
    val departureDateTime: String,
    val arrivalDateTime: String,
    val carrier: Long,
    val operatingCarriers: List<Long>,
    val duration: Int,
    val flightNumber: String,
    val journeyMode: String,
    val directionality: String,
)

data class Carrier(
    val id: Long,
    val code: String,
    val name: String,
    val imageUrl: String,
    val displayCode: String,
)

data class Agent(
    val id: Long,
    val name: String,
    val imageUrl: String,
    val status: String,
    val optimisedForMobile: Boolean,
    val type: String,
)

data class Place(
    val id: Long,
    val parentId: Long,
    val code: String,
    val type: String,
    val name: String,
)

data class Currency(
    val code: String,
    val symbol: String,
    val thousandsSeparator: String,
    val decimalSeparator: String,
    val symbolOnLeft: Boolean,
    val spaceBetweenAmountAndSymbol: Boolean,
    val roundingCoefficient: Int,
    val decimalDigits: Int
)

