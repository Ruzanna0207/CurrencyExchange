package com.manage.converter.core.view_model

import androidx.lifecycle.ViewModel
import com.manage.converter.core.controller.ChannelScreenController
import com.manage.converter.core.controller.ScreenController

abstract class ChannelViewModel<Action : Any, UiState : Any, Effect : Any>(
    initialUiState: UiState,
) : ViewModel(), ScreenController<Action, UiState, Effect> by ChannelScreenController(
    initialUiState
)