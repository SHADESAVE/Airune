package com.example.airplan.home.domain.entity

import androidx.compose.runtime.Immutable
import com.example.airplan.home.data.model.Agent

@Immutable
data class Destination(
    val agent: Agent?,
    val name: String,
    val departure: String,
    val arrival: String,
    val price: Double,
    val currencySymbol: String,
    val description: String,
    val deeplink: String,
)