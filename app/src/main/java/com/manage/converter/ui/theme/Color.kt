package com.manage.converter.ui.theme

import androidx.compose.ui.graphics.Color


sealed class DefaultColor {
    abstract val primary: Color
    abstract val onPrimary: Color
    abstract val primaryContainer: Color
    abstract val onPrimaryContainer: Color

    abstract val secondary: Color
    abstract val onSecondary: Color
    abstract val secondaryContainer: Color
    abstract val onSecondaryContainer: Color

    abstract val tertiary: Color
    abstract val onTertiary: Color
    abstract val tertiaryContainer: Color
    abstract val onTertiaryContainer: Color

    abstract val surfaceVariant: Color
    abstract val onSurfaceVariant: Color

    data object Light : DefaultColor() {
        override val primary: Color = Color(0xFF4278E7)
        override val onPrimary: Color = Color(0xFFFFFFFF)
        override val primaryContainer: Color = Color(0xFF1D5AD2)
        override val onPrimaryContainer: Color = Color(0xFF1D48D7)

        override val secondary: Color = Color(0xFF000000)
        override val onSecondary: Color = Color(0xFFFFFFFF)
        override val secondaryContainer: Color = Color(0xFFF5F5F5)
        override val onSecondaryContainer: Color = Color(0xFF969696)

        override val tertiary: Color = Color(0xFF13B1F4)
        override val onTertiary: Color = Color(0xFFFFFFFF)
        override val tertiaryContainer: Color = Color(0xFF00B3FF)
        override val onTertiaryContainer: Color = Color(0xFF0688EC)

        override val surfaceVariant: Color = Color(0xFF969696)
        override val onSurfaceVariant: Color = Color(0xFF5C5C5C)
    }

    data object Dark : DefaultColor() {
        override val primary: Color = Color(0xFF4278E7)
        override val onPrimary: Color = Color(0xFFFFFFFF)
        override val primaryContainer: Color = Color(0xFF1D48D7)
        override val onPrimaryContainer: Color = Color(0xFF7BA1EE)

        override val secondary: Color = Color(0xFFFFFFFF)
        override val onSecondary: Color = Color(0xFF000000)
        override val secondaryContainer: Color = Color(0xFF181818)
        override val onSecondaryContainer: Color = Color(0xFF838383)

        override val tertiary: Color = Color(0xFF13B1F4)
        override val onTertiary: Color = Color(0xFFFFFFFF)
        override val tertiaryContainer: Color = Color(0xFF0688EC)
        override val onTertiaryContainer: Color = Color(0xFF5AC8F7)

        override val surfaceVariant: Color = Color(0xFF838383)
        override val onSurfaceVariant: Color = Color(0xFFA1A1A1)
    }
}
