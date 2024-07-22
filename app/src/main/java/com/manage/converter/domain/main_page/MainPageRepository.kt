package com.manage.converter.domain.main_page

import com.manage.converter.domain.model.ExchangeRatesResponse

interface MainPageRepository {

    suspend fun getCurrency(id: String, base: String): ExchangeRatesResponse

    suspend fun getListNames(id: String): Map<String, String>
}