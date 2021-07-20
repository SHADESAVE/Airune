package com.example.airplan.home.presentation

import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

abstract class BaseViewModel : ViewModel() {

    private val compositeDisposable = CompositeDisposable()

    override fun onCleared() {
        compositeDisposable
        super.onCleared()
    }

    protected fun Disposable.addToDisposable(): Disposable =
        apply { compositeDisposable.add(this) }
}