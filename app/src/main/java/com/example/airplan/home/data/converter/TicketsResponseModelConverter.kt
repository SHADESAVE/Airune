package com.example.airplan.home.data.converter

import com.example.airplan.home.data.model.TicketsResponseModel
import com.example.airplan.home.domain.entity.Destination
import javax.inject.Inject

class TicketsResponseModelConverter @Inject constructor() {

    fun convert(from: TicketsResponseModel): List<Destination> =
        from.itineraries.flatMap { itinerary ->
            itinerary.pricingOptions.map { pricingOption ->
                Destination(
                    agent = from.agents.firstOrNull() { it.id == pricingOption.agents.firstOrNull() },
                    name = "",
                    departure = "",
                    arrival = "",
                    price = pricingOption.price,
                    currencySymbol = "${from.currencies.firstOrNull()?.symbol}",
                    description = "",
                    deeplink = pricingOption.deeplinkUrl,
                )
            }
        }
}
