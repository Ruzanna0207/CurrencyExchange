package com.manage.converter.ui.theme

import androidx.compose.runtime.Immutable
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Immutable
data class Sizing(
    val size16: Dp,
    val size18: Dp,
    val size20: Dp,
    val size24: Dp,
    val size32: Dp,
    val size36: Dp,
    val size48: Dp,
    val size56: Dp,
    val size64: Dp,
    val size68: Dp,
    val size72: Dp,
    val size96: Dp
)

internal val sizing = Sizing(
    size16 = 16.dp,
    size18 = 18.dp,
    size20 = 20.dp,
    size24 = 24.dp,
    size32 = 32.dp,
    size36 = 36.dp,
    size48 = 48.dp,
    size56 = 56.dp,
    size64 = 64.dp,
    size68 = 68.dp,
    size72 = 72.dp,
    size96 = 96.dp
)

@Immutable
data class BorderWidths(
    val borderWidth1: Dp,
    val borderWidth2: Dp,
    val borderWidth4: Dp,
)

internal val borderWidths = BorderWidths(
    borderWidth1 = 1.dp,
    borderWidth2 = 2.dp,
    borderWidth4 = 4.dp,
)


