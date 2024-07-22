package com.manage.converter.main_page_screen.buttons

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.manage.converter.R
import com.manage.converter.compose_state.CheckValueAction
import com.manage.converter.compose_state.CheckValueUiState
import com.manage.converter.main_page_screen.animation.AnimationForEnteredValues
import com.manage.converter.main_page_screen.bottom_sheet.BottomSheetForList
import com.manage.converter.ui.theme.spacing

@Composable
fun CurrentExchangeButtonForBottomSheet(
    uiState: CheckValueUiState,
    onAction: (CheckValueAction) -> Unit,
) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        if (uiState.enteredCourse == null) {
            AnimationForEnteredValues()
        }

        TextButton(
            modifier = Modifier.padding(bottom = spacing.padding24),
            onClick = {
                onAction(CheckValueAction.OnCodeChecked(true))
            }
        ) {
            Text(
                text = stringResource(R.string.text_button_click),
                style = MaterialTheme.typography.headlineMedium
            )
        }

        if (uiState.bottomSheetState) {
            BottomSheetForList(uiState = uiState, onAction = onAction) {
                onAction(CheckValueAction.OnCodeChecked(false))
            }
        }
    }
}