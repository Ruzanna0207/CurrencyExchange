package com.manage.converter.core.compose_state

open class BaseUiState(
    open val isLoading: Boolean? = true,
    open val errorMessage: ErrorUiState? = null,
    open val isEmpty: Boolean? = false
)

open class ErrorUiState(
    open val message: String,
    open var isShow: Boolean = true
)