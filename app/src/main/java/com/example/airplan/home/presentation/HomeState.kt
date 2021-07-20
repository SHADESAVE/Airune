package com.example.airplan.home.presentation

import com.example.airplan.home.domain.entity.Destination

sealed class HomeState {

    object Loading : HomeState()

    data class TicketsLoaded(
        val ticketList: List<Destination>
    ) : HomeState()
}