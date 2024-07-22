package com.manage.converter.main_page_screen.icon

import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.Color

@Immutable
sealed class IconBackground {

    data class NoBackground(val size: NoBackgroundIconSize) : IconBackground()

    data class Round(val background: Color, val size: ColoredIconSize) : IconBackground()

    data class Square(val background: Color, val size: ColoredIconSize) : IconBackground()
}
