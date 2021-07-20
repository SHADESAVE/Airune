package com.example.airplan.home.presentation

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.airplan.home.data.model.TicketsSessionModel
import com.example.airplan.home.domain.entity.Destination
import com.example.airplan.home.domain.usecase.GetHotelsUseCase
import com.example.airplan.home.domain.usecase.GetTicketsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import kotlinx.coroutines.launch
import javax.inject.Inject

const val MAX_PEOPLE = 4
const val HEADER = "Location"

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getTicketsUseCase: GetTicketsUseCase,
    private val getHotelsUseCase: GetHotelsUseCase,
) : BaseViewModel() {

    private val _peopleCount = MutableLiveData<String>()
    val peopleCount: LiveData<String> = _peopleCount

    private val _destinationFrom = MutableLiveData<String>()
    val destinationFrom: LiveData<String> = _destinationFrom

    private val _destinationTo = MutableLiveData<String>()
    val destinationTo: LiveData<String> = _destinationTo

    private val _date = MutableLiveData<String>()
    val date: LiveData<String> = _date

    private val _tickets = MutableLiveData<List<Destination>>()
    val tickets: LiveData<List<Destination>> = _tickets

    private val _hotels = MutableLiveData<List<Destination>>()
    val hotels: LiveData<List<Destination>> = _hotels

    private val _state = MutableLiveData<HomeState>()
    val state: LiveData<HomeState> = _state

    init {
        getTickets(TicketsSessionModel.BASE)
    }

    private fun getTickets(sessionModel: TicketsSessionModel) {
        getTicketsUseCase(sessionModel)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ tickets ->
                _tickets.value = tickets
            }, ::onError)
            .addToDisposable()
    }

    private fun getHotels() {
        getHotelsUseCase()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ hotels ->
                _hotels.value = hotels
            }, ::onError)
            .addToDisposable()
    }

    fun updatePeople(peopleCount: Int) {
        viewModelScope.launch {
            if (peopleCount > MAX_PEOPLE) {
                _tickets.value = emptyList()
                _hotels.value = emptyList()
            } else {
                //TODO избавиться от двойных запросов
                getTickets(TicketsSessionModel.BASE)
                getHotels()
            }
        }
    }

    private fun onError(throwable: Throwable) {
        Log.e("subscribeError", throwable.toString())
    }

    fun openDeeplink(deeplink: String) {

    }

    fun updateDestinationTo(destinationTo: String) {
        _destinationTo.value = destinationTo
    }
}