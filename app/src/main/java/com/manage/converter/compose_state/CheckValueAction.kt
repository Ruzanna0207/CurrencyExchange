package com.manage.converter.compose_state

import com.manage.converter.presentation.data_classes.CurrencyValuesWithName

sealed interface CheckValueAction {

    data class OnActualCourseEntered(val currencyValue: CurrencyValuesWithName) : CheckValueAction

    data class OnCodeChecked(val checked: Boolean) : CheckValueAction

    data class OnValueCodeEntered(val value: String) : CheckValueAction

    data object OnClearAllEnteredValues : CheckValueAction

    data class OnGetTotalExchange(val code: Double, val userValue: Double) : CheckValueAction
}