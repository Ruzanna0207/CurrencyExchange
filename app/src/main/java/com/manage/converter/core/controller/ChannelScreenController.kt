package com.manage.converter.core.controller

import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.receiveAsFlow

class ChannelScreenController<Action : Any, UiState : Any, Effect : Any>(
    initialUiState: UiState
) : DefaultScreenController<Action, UiState, Effect>(initialUiState) {

    override val effect: Flow<Effect>
        get() = _effect.receiveAsFlow()
    private val _effect = Channel<Effect>()

    override suspend fun setEffect(effect: Effect) {
        _effect.send(effect)
    }
}