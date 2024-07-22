package com.manage.converter.main_page_screen.entered_values

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.manage.converter.ui.theme.spacing

@Composable
fun TotalValue(value: String, name: String) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Text(
            modifier = Modifier.padding(spacing.padding16),
            text = value,
            style = MaterialTheme.typography.displayLarge
        )
        Text(
            modifier = Modifier, text = " in $name", style = MaterialTheme.typography.headlineMedium
        )
    }
}