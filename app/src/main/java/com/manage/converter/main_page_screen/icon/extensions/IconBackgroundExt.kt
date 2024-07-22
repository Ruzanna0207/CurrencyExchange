package com.manage.converter.main_page_screen.icon.extensions

import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Dp
import com.manage.converter.main_page_screen.icon.ColoredIconSize
import com.manage.converter.main_page_screen.icon.IconBackground
import com.manage.converter.main_page_screen.icon.NoBackgroundIconSize
import com.manage.converter.ui.theme.sizing

@Composable
fun IconBackground.getSize(): Dp =
    when (this) {
        is IconBackground.NoBackground -> {
            when (this.size) {
                NoBackgroundIconSize.XXSmall -> sizing.size16
                NoBackgroundIconSize.XSmall -> sizing.size18
                NoBackgroundIconSize.Small -> sizing.size24
                NoBackgroundIconSize.Medium -> sizing.size36
                NoBackgroundIconSize.XXLarge -> sizing.size64
            }
        }

        is IconBackground.Round -> {
            when (this.size) {
                ColoredIconSize.Small -> sizing.size16
                ColoredIconSize.Medium -> sizing.size24
                ColoredIconSize.Large -> sizing.size36
                ColoredIconSize.XLarge -> sizing.size56
            }
        }

        is IconBackground.Square -> {
            when (this.size) {
                ColoredIconSize.Small -> sizing.size16
                ColoredIconSize.Medium -> sizing.size24
                ColoredIconSize.Large -> sizing.size36
                ColoredIconSize.XLarge -> sizing.size56
            }
        }
    }

@Composable
fun IconBackground.getShape(): Shape? = when (this) {
    is IconBackground.Square -> RoundedCornerShape(this.size.getBorderRadius())
    is IconBackground.Round -> CircleShape
    is IconBackground.NoBackground -> null
}
