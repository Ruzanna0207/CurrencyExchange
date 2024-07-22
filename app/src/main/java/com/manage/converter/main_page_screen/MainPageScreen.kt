package com.manage.converter.main_page_screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.manage.converter.compose_state.CheckValueAction
import com.manage.converter.compose_state.CheckValueUiState
import com.manage.converter.core.consts.STORAGE.EMPTY
import com.manage.converter.core.consts.STORAGE.image
import com.manage.converter.main_page_screen.buttons.CalculateButton
import com.manage.converter.main_page_screen.keyboard.CheckValueWithKeyboard
import com.manage.converter.main_page_screen.entered_values.TotalEnteredValue
import com.manage.converter.main_page_screen.buttons.CurrentExchangeButtonForBottomSheet
import com.manage.converter.main_page_screen.entered_values.SelectedCourse
import com.manage.converter.main_page_screen.entered_values.TotalValue
import com.manage.converter.main_page_screen.title.Title
import com.manage.converter.ui.theme.ConverterTheme
import com.manage.converter.ui.theme.spacing

@Composable
fun MainPageScreen(
    uiState: CheckValueUiState,
    onAction: (CheckValueAction) -> Unit,
) {
    ConverterTheme {
        Image(url = image)
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = spacing.padding24),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Title()

            uiState.enteredCourse?.let {
                SelectedCourse(it)
            }

            TotalEnteredValue(uiState.enteredValue)

            CheckValueWithKeyboard(onAction = onAction)

            uiState.totalValue?.let {
                TotalValue(value = it, uiState.enteredCourse?.name ?: EMPTY)
            }

            CalculateButton(enteredValue = uiState.enteredValue, course = uiState.course) {
                onAction(
                    CheckValueAction.OnGetTotalExchange(
                        uiState.course, uiState.enteredValue.toDoubleOrNull() ?: 0.0
                    )
                )
            }

            Spacer(modifier = Modifier.weight(0.7f))

            CurrentExchangeButtonForBottomSheet(uiState = uiState, onAction = onAction)
        }
    }
}