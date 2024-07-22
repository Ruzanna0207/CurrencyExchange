package com.manage.converter.ui.theme

import androidx.compose.runtime.Immutable
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Immutable
data class BorderRadius(
    val borderRadius4: Dp,
    val borderRadius8: Dp,
    val borderRadius12: Dp,
    val borderRadius16: Dp,
    val borderRadius24: Dp,
)

internal val borderRadius = BorderRadius(
    borderRadius4 = 4.dp,
    borderRadius8 = 8.dp,
    borderRadius12 = 12.dp,
    borderRadius16 = 16.dp,
    borderRadius24 = 36.dp,
)
