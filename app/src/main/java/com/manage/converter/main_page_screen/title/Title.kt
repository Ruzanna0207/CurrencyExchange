package com.manage.converter.main_page_screen.title

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.manage.converter.R
import com.manage.converter.ui.theme.spacing

@Composable
fun Title() {
    Text(
        text = stringResource(R.string.currency_exchange),
        modifier = Modifier.padding(spacing.padding24),
        style = MaterialTheme.typography.displayMedium
    )
}