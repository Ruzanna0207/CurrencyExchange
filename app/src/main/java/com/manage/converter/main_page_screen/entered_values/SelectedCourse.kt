package com.manage.converter.main_page_screen.entered_values

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.manage.converter.R
import com.manage.converter.presentation.data_classes.CurrencyValuesWithName
import com.manage.converter.ui.theme.spacing

@Composable
fun SelectedCourse(courseWithName: CurrencyValuesWithName) {
    ElevatedCard(modifier = Modifier.padding(spacing.padding8)) {
        Row(
            modifier = Modifier.padding(spacing.padding12),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text(
                    text = stringResource(id = R.string.selected_currency),
                    style = MaterialTheme.typography.labelLarge
                )
                Text(
                    text = courseWithName.code,
                    style = MaterialTheme.typography.displayMedium
                )
                Text(
                    text = courseWithName.value.toString(),
                    style = MaterialTheme.typography.labelSmall
                )
            }
            Text(
                modifier = Modifier.padding(start = spacing.padding16),
                text = courseWithName.name,
                style = MaterialTheme.typography.displaySmall
            )
        }
    }
}