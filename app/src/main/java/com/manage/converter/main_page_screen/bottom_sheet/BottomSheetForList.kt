package com.manage.converter.main_page_screen.bottom_sheet

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.manage.converter.presentation.data_classes.CurrencyValuesWithName
import com.manage.converter.R
import com.manage.converter.compose_state.CheckValueAction
import com.manage.converter.compose_state.CheckValueUiState
import com.manage.converter.ui.theme.spacing

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BottomSheetForList(
    modifier: Modifier = Modifier,
    uiState: CheckValueUiState,
    onAction: (CheckValueAction) -> Unit,
    onDismiss: () -> Unit
) {
    ModalBottomSheet(
        modifier = modifier,
        onDismissRequest = onDismiss,
        containerColor = MaterialTheme.colorScheme.onPrimary,
        sheetState = rememberModalBottomSheetState()
    ) {
        LazyColumn(
            modifier = Modifier.padding(spacing.padding16),
            verticalArrangement = Arrangement.Center
        ) {
            item {
                Text(
                    text = stringResource(R.string.current_exchange_rates),
                    modifier = Modifier.padding(spacing.padding12),
                    style = MaterialTheme.typography.headlineLarge
                )
            }
            uiState.valueWithName?.let { list ->
                items(list) { nameWithValue ->
                    CurrencyText(courseWithName = nameWithValue) {
                        onAction(CheckValueAction.OnActualCourseEntered(it))
                        onAction(CheckValueAction.OnCodeChecked(false))
                    }
                }
            }
        }
    }
}

@Composable
fun CurrencyText(
    courseWithName: CurrencyValuesWithName,
    onClick: (CurrencyValuesWithName) -> Unit
) {
    ElevatedCard(
        Modifier
            .fillMaxWidth()
            .padding(bottom = spacing.padding12)
            .clickable {
                onClick(courseWithName)
            },
    ) {
        Column(
            modifier = Modifier
                .padding(spacing.padding12),
            verticalArrangement = Arrangement.Center
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(
                    text = courseWithName.code,
                    modifier = Modifier.padding(spacing.padding12),
                    style = MaterialTheme.typography.headlineMedium
                )
                Text(
                    text = courseWithName.name,
                    modifier = Modifier.padding(spacing.padding12),
                    style = MaterialTheme.typography.headlineMedium
                )
            }

            Column {
                Text(
                    text = stringResource(R.string.current_exchange_rates_to_usd),
                    modifier = Modifier.padding(spacing.padding8),
                    style = MaterialTheme.typography.labelLarge
                )
                Text(
                    text = courseWithName.value.toString(),
                    modifier = Modifier.padding(start = spacing.padding8),
                    style = MaterialTheme.typography.headlineMedium
                )
            }
        }
    }
}