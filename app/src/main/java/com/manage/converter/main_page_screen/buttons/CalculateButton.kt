package com.manage.converter.main_page_screen.buttons

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.manage.converter.ui.theme.spacing

@Composable
fun CalculateButton(enteredValue: String, course: Double, onClick: () -> Unit) {
    if (enteredValue.isNotEmpty() && course > 0.0) {
        FilledTonalButton(
            modifier = Modifier
                .fillMaxWidth()
                .padding(spacing.padding12),
            colors = ButtonColors(
                containerColor = MaterialTheme.colorScheme.primaryContainer,
                contentColor = MaterialTheme.colorScheme.onPrimaryContainer,
                disabledContentColor = MaterialTheme.colorScheme.surface,
                disabledContainerColor = MaterialTheme.colorScheme.onSurface
            ),
            onClick = onClick
        ) {
            Text(
                modifier = Modifier.padding(spacing.padding16),
                text = "Calculate",
                style = MaterialTheme.typography.headlineMedium
            )
        }
    }
}