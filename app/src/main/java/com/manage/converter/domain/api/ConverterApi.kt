package com.manage.converter.domain.api

import com.manage.converter.domain.model.ExchangeRatesResponse
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface ConverterApi {

    @GET("latest.json")
    suspend fun getLatestRates(
        @Query("app_id") appId: String,
        @Query("base") base: String,
    ): ExchangeRatesResponse

    @GET("currencies.json")
    suspend fun getCurrencies(
        @Query("app_id") appId: String
    ): Map<String, String>

}

object ConverterApiFactory {
    fun create(): ConverterApi {
        val retrofit = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("https://openexchangerates.org/api/")
            .build()
        return retrofit.create(ConverterApi::class.java)
    }
}