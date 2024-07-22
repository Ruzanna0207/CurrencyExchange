package com.manage.converter.presentation

import android.util.Log
import androidx.lifecycle.viewModelScope
import com.manage.converter.compose_state.CheckValueAction
import com.manage.converter.compose_state.CheckValueEffect
import com.manage.converter.compose_state.CheckValueUiState
import com.manage.converter.core.consts.STORAGE.DOUBLE_ZERO
import com.manage.converter.core.consts.STORAGE.EMPTY
import com.manage.converter.core.consts.STORAGE.appId
import com.manage.converter.core.consts.STORAGE.base
import com.manage.converter.core.view_model.ChannelViewModel
import com.manage.converter.domain.main_page.MainPageRepository
import com.manage.converter.domain.model.ExchangeRatesResponse
import com.manage.converter.presentation.data_classes.CurrencyValuesWithName
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.text.DecimalFormat
import java.text.DecimalFormatSymbols
import java.util.Locale
import kotlin.math.roundToInt

class MainPageViewModel(
    private val repository: MainPageRepository
) :
    ChannelViewModel<CheckValueAction, CheckValueUiState, CheckValueEffect>(initialUiState = CheckValueUiState()) {

    override fun action(action: CheckValueAction) {
        when (action) {
            is CheckValueAction.OnActualCourseEntered -> onCodeEntered(action.currencyValue)
            is CheckValueAction.OnValueCodeEntered -> onValueEntered(action.value)
            is CheckValueAction.OnCodeChecked -> onCodeChecked(action.checked)
            is CheckValueAction.OnGetTotalExchange -> getExchangeTotalValue(
                action.code,
                action.userValue
            )

            is CheckValueAction.OnClearAllEnteredValues -> clearEnteredValues()
        }
    }

    init {
        getCurrency()
    }

    private fun onValueEntered(value: String) {
        setState(
            uiState.value.copy(
                enteredValue = value,
            )
        )
    }

    private fun clearEnteredValues() {
        setState(
            uiState.value.copy(
                totalValue = null,
                enteredCourse = null,
                enteredValue = EMPTY,
                course = DOUBLE_ZERO,
            )
        )
    }

    private fun onCodeChecked(course: Boolean) {
        setState(uiState.value.copy(bottomSheetState = course))
    }

    private fun onCodeEntered(course: CurrencyValuesWithName) {
        setState(
            uiState.value.copy(
                totalValue = null,
                enteredCourse = course,
                course = course.value
            )
        )
    }

    private fun getExchangeTotalValue(course: Double, userValue: Double) {
        val rounded = formatNumber(course * userValue)
        setState(uiState.value.copy(totalValue = rounded))
    }

    private fun getCurrency() = viewModelScope.launch(Dispatchers.IO) {
        try {
            val value = repository.getCurrency(id = appId, base = base)
            val listNames = repository.getListNames(id = appId)
            val valuesWithName =
                combineCurrencyData(currencyListResponse = listNames, exchangeRatesResponse = value)
            setState(
                uiState.value.copy(
                    valueWithName = valuesWithName
                )
            )
        } catch (e: Exception) {
            Log.e("getCurrency", "Error fetching currency", e)
        }
    }


    private fun combineCurrencyData(
        currencyListResponse: Map<String, String>,
        exchangeRatesResponse: ExchangeRatesResponse
    ): List<CurrencyValuesWithName> {
        val currencyValuesWithNameList = mutableListOf<CurrencyValuesWithName>()

        for ((code, name) in currencyListResponse) {
            val value = exchangeRatesResponse.rates[code]
            if (value != null) {
                val roundedValue = (value * 10).roundToInt() / 10.0
                currencyValuesWithNameList.add(
                    CurrencyValuesWithName(
                        name = name,
                        code = code,
                        value = roundedValue
                    )
                )
            }
        }
        return currencyValuesWithNameList
    }

    private fun formatNumber(number: Double): String {
        val symbols = DecimalFormatSymbols(Locale.getDefault()).apply {
            groupingSeparator = ' '
        }
        val formatter = DecimalFormat("#,###.0", symbols)
        return formatter.format(number)
    }
}