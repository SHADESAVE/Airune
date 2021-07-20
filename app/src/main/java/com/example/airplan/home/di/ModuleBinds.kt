package com.example.airplan.home.di

import com.example.airplan.home.data.datasource.HotelsDataSource
import com.example.airplan.home.data.datasource.HotelsDataSourceImpl
import com.example.airplan.home.data.datasource.TicketsDataSource
import com.example.airplan.home.data.datasource.TicketsDataSourceImpl
import com.example.airplan.home.data.repository.HotelsRepositoryImpl
import com.example.airplan.home.data.repository.TicketsRepositoryImpl
import com.example.airplan.home.domain.repository.HotelsRepository
import com.example.airplan.home.domain.repository.TicketsRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class TicketsModule {

    @Binds
    abstract fun bindRepository(ticketsRepositoryImpl: TicketsRepositoryImpl): TicketsRepository

    @Binds
    abstract fun bindDataSource(ticketsDataSourceImpl: TicketsDataSourceImpl): TicketsDataSource
}

@Module
@InstallIn(SingletonComponent::class)
abstract class Hotels {

    @Binds
    abstract fun bindRepository(hotelsRepositoryImpl: HotelsRepositoryImpl): HotelsRepository

    @Binds
    abstract fun bindDataSource(hotelsDataSourceImpl: HotelsDataSourceImpl): HotelsDataSource
}