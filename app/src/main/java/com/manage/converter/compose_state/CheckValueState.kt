package com.manage.converter.compose_state

import com.manage.converter.presentation.data_classes.CurrencyValuesWithName
import com.manage.converter.core.compose_state.BaseUiState
import com.manage.converter.core.compose_state.ErrorUiState
import com.manage.converter.core.consts.STORAGE.DOUBLE_ZERO
import com.manage.converter.core.consts.STORAGE.EMPTY

data class CheckValueUiState(
    val totalValue: String? = null,
    val enteredCourse: CurrencyValuesWithName? = null,
    val valueWithName: List<CurrencyValuesWithName>?= null,
    val bottomSheetState: Boolean = false,
    val course: Double = DOUBLE_ZERO,
    val enteredValue: String = EMPTY,

    override val isLoading: Boolean = true,
    override val isEmpty: Boolean = false,
    override val errorMessage: ErrorUiState? = null,
) : BaseUiState()