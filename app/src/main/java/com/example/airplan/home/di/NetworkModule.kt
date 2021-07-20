package com.example.airplan.home.di

import com.example.airplan.home.data.datasource.HotelsDataSourceImpl
import com.example.airplan.home.data.datasource.TicketsDataSourceImpl
import com.example.airplan.home.data.network.HotelsApi
import com.example.airplan.home.data.network.TicketsApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.reactivex.schedulers.Schedulers
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {
    private const val BASE_URL_FOR_PARTNERS = "https://partners.api.skyscanner.net/"
    private const val BASE_URL = "https://skyscanner-skyscanner-flight-search-v1.p.rapidapi.com/"
    private const val RAPID_API_KEY_HEADER = "x-rapidapi-key"
    private const val RAPID_API_KEY = "2ae0a640c0msh88ed43816a22016p1e94e3jsn4cb53ab47da4"
    private const val RAPID_API_HOST_HEADER = "x-rapidapi-host"
    private const val RAPID_API_HOST = "skyscanner-skyscanner-flight-search-v1.p.rapidapi.com"

    @Singleton
    @Provides
    fun provideHttpLoggingInterceptor(): HttpLoggingInterceptor =
        HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BODY }

    @Singleton
    @Provides
    fun provideOkHttpClient(loggingInterceptor: HttpLoggingInterceptor): OkHttpClient =
        OkHttpClient
            .Builder()
            .addInterceptor(loggingInterceptor)
//            .addInterceptor { chain ->
//                chain.run {
//                    proceed(
//                        request().newBuilder()
//                            .addHeader(RAPID_API_KEY_HEADER, RAPID_API_KEY)
//                            .addHeader(RAPID_API_HOST_HEADER, RAPID_API_HOST)
//                            .build()
//                    )
//                }
//            }
            .build()

    @Singleton
    @Provides
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit =
        Retrofit
            .Builder()
            .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io()))
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL_FOR_PARTNERS)
            .client(okHttpClient)
            .build()

    @Singleton
    @Provides
    fun provideTicketsApi(retrofit: Retrofit): TicketsApi =
        retrofit.create(TicketsApi::class.java)

    @Singleton
    @Provides
    fun provideHotelsApi(retrofit: Retrofit): HotelsApi =
        retrofit.create(HotelsApi::class.java)

    @Singleton
    @Provides
    fun provideTicketsDataSource(ticketsApi: TicketsApi) =
        TicketsDataSourceImpl(ticketsApi)

    @Singleton
    @Provides
    fun provideHotelsDataSource(hotelsApi: HotelsApi) =
        HotelsDataSourceImpl(hotelsApi)
}