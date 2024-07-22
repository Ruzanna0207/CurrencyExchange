package com.manage.converter.data.main_page

import com.manage.converter.domain.model.ExchangeRatesResponse
import com.manage.converter.domain.api.ConverterApi
import com.manage.converter.domain.main_page.MainPageRepository

class MainPageRepositoryImpl(
    private val converterApi: ConverterApi
) : MainPageRepository {

    override suspend fun getCurrency(
        id: String,
        base: String,
    ): ExchangeRatesResponse {
        return converterApi.getLatestRates(appId = id, base = base)
    }

    override suspend fun getListNames(id: String): Map<String, String> {
        return converterApi.getCurrencies(appId = id)
    }
}