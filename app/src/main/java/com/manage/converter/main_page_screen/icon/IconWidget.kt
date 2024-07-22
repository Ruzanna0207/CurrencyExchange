package com.manage.converter.main_page_screen.icon

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.manage.converter.main_page_screen.icon.extensions.getPadding
import com.manage.converter.main_page_screen.icon.extensions.getShape
import com.manage.converter.main_page_screen.icon.extensions.getSize

@Composable
fun IconWidget(
    painter: Painter,
    iconBackground: IconBackground,
    modifier: Modifier = Modifier,
    contentDescription: String? = null,
    colorFilter: ColorFilter? = null,
    onClick: (() -> Unit)? = null,
    boundedRipple: Boolean = iconBackground.getShape() != null,
) {

    val isClickable = onClick != null
    val shape = iconBackground.getShape()

    val backgroundModifier = if (shape != null) {
        Modifier
            .background(
                color = when (iconBackground) {
                    is IconBackground.Round -> iconBackground.background
                    is IconBackground.Square -> iconBackground.background
                    is IconBackground.NoBackground -> Color.Transparent
                },
                shape = shape,
            )
            .clip(shape = shape)
    } else {
        Modifier
    }

    val clickableModifier = if (isClickable) {
        Modifier
            .clickable(
                interactionSource = remember { MutableInteractionSource() },
                indication = rememberRipple(
                    bounded = boundedRipple,
                    radius = if (boundedRipple) Dp.Unspecified else iconBackground.getSize(),
                ),
                enabled = isClickable,
                role = Role.Button,
                onClick = {
                    onClick?.invoke()
                },
            )
    } else {
        Modifier
    }

    Image(
        painter = painter,
        contentDescription = contentDescription,
        colorFilter = colorFilter,
        modifier = modifier
            .then(backgroundModifier)
            .then(clickableModifier)
            .padding(
                when (iconBackground) {
                    is IconBackground.Round -> iconBackground.size.getPadding()
                    is IconBackground.Square -> iconBackground.size.getPadding()
                    is IconBackground.NoBackground -> 0.dp
                }
            )
            .size(iconBackground.getSize())
    )
}
