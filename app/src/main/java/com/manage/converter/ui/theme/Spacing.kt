package com.manage.converter.ui.theme

import androidx.compose.runtime.Immutable
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Immutable
data class Spacing(
    val padding2: Dp,
    val padding4: Dp,
    val padding8: Dp,
    val padding12: Dp,
    val padding16: Dp,
    val padding20: Dp,
    val padding24: Dp,
)

internal val spacing = Spacing(
    padding2 = 2.dp,
    padding4 = 4.dp,
    padding8 = 8.dp,
    padding12 = 12.dp,
    padding16 = 16.dp,
    padding20 = 20.dp,
    padding24 = 24.dp,
)

