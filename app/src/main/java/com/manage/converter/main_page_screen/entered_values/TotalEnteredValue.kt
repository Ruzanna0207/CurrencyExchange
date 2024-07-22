package com.manage.converter.main_page_screen.entered_values

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.manage.converter.R
import com.manage.converter.main_page_screen.animation.AnimationForEnteredValues
import com.manage.converter.ui.theme.spacing

@Composable
fun TotalEnteredValue(value: String) {
    if (value.isNotEmpty()) {
        Column(
            modifier = Modifier.padding(spacing.padding8),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = stringResource(R.string.your_value),
                style = MaterialTheme.typography.headlineMedium
            )
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(text = value, style = MaterialTheme.typography.displayLarge)
                Text(
                    modifier = Modifier.padding(spacing.padding4),
                    text = stringResource(R.string.usd),
                    style = MaterialTheme.typography.displayLarge
                )
            }
        }
    } else {
        Row(modifier = Modifier.padding(spacing.padding12),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                modifier = Modifier.padding(spacing.padding12),
                text = stringResource(R.string.enter_value),
                style = MaterialTheme.typography.headlineSmall
            )
            AnimationForEnteredValues()
        }
    }
}