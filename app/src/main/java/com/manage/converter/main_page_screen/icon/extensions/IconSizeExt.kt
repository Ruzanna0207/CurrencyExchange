package com.manage.converter.main_page_screen.icon.extensions

import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.Dp
import com.manage.converter.main_page_screen.icon.ColoredIconSize
import com.manage.converter.ui.theme.borderRadius
import com.manage.converter.ui.theme.spacing

@Composable
fun ColoredIconSize.getPadding(): Dp =
    when (this) {
        ColoredIconSize.Small -> spacing.padding12
        ColoredIconSize.Medium -> spacing.padding16
        ColoredIconSize.Large -> spacing.padding20
        ColoredIconSize.XLarge -> spacing.padding24
    }

@Composable
fun ColoredIconSize.getBorderRadius(): Dp = when (this) {
    ColoredIconSize.Small -> borderRadius.borderRadius4
    ColoredIconSize.Medium -> borderRadius.borderRadius8
    ColoredIconSize.Large -> borderRadius.borderRadius12
    ColoredIconSize.XLarge -> borderRadius.borderRadius16
}
