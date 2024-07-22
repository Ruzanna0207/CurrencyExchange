package com.manage.converter.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.manage.converter.R


val fonts = FontFamily(
    Font(resId = R.font.museo_sans_cyrl_100, weight = FontWeight.W100),
    Font(resId = R.font.museo_sans_cyrl_300, weight = FontWeight.W300),
    Font(resId = R.font.museo_sans_cyrl_500, weight = FontWeight.W500),
    Font(resId = R.font.museo_sans_cyrl_700, weight = FontWeight.W700),
)

val Typography = Typography(
    displayLarge = TextStyle(
        fontFamily = fonts,
        fontWeight = FontWeight.W600,
        fontSize = 32.sp,
        letterSpacing = 0.sp,
        lineHeight = 40.sp
    ),
    displayMedium = TextStyle(
        fontFamily = fonts,
        fontWeight = FontWeight.W400,
        fontSize = 28.sp,
        letterSpacing = 0.sp,
        lineHeight = 36.sp
    ),
    displaySmall = TextStyle(
        fontFamily = fonts,
        fontWeight = FontWeight.W400,
        fontSize = 24.sp,
        letterSpacing = 0.4.sp,
        lineHeight = 32.sp
    ),

    headlineLarge = TextStyle(
        fontFamily = fonts,
        fontWeight = FontWeight.W600,
        fontSize = 22.sp,
        letterSpacing = 1.2.sp,
        lineHeight = 28.sp
    ),
    headlineMedium = TextStyle(
        fontFamily = fonts,
        fontWeight = FontWeight.W600,
        fontSize = 18.sp,
        letterSpacing = 1.2.sp,
        lineHeight = 24.sp
    ),
    headlineSmall = TextStyle(
        fontFamily = fonts,
        fontWeight = FontWeight.W600,
        fontSize = 14.sp,
        letterSpacing = 0.6.sp,
        lineHeight = 20.sp
    ),

    titleLarge = TextStyle(
        fontFamily = fonts,
        fontWeight = FontWeight.W400,
        fontSize = 16.sp,
        letterSpacing = 0.4.sp,
        lineHeight = 24.sp
    ),
    titleMedium = TextStyle(
        fontFamily = fonts,
        fontWeight = FontWeight.W300,
        fontSize = 16.sp,
        letterSpacing = 0.sp,
        lineHeight = 24.sp
    ),

    bodyLarge = TextStyle(
        fontFamily = fonts,
        fontWeight = FontWeight.W400,
        fontSize = 14.sp,
        letterSpacing = 0.4.sp,
        lineHeight = 20.sp
    ),
    bodyMedium = TextStyle(
        fontFamily = fonts,
        fontWeight = FontWeight.W300,
        fontSize = 14.sp,
        letterSpacing = 0.sp,
        lineHeight = 20.sp
    ),

    labelLarge = TextStyle(
        fontFamily = fonts,
        fontWeight = FontWeight.W400,
        fontSize = 12.sp,
        letterSpacing = 0.4.sp,
        lineHeight = 16.sp
    ),
    labelMedium = TextStyle(
        fontFamily = fonts,
        fontWeight = FontWeight.W300,
        fontSize = 12.sp,
        letterSpacing = 0.4.sp,
        lineHeight = 16.sp
    ),
    labelSmall = TextStyle(
        fontFamily = fonts,
        fontWeight = FontWeight.W300,
        fontSize = 10.sp,
        letterSpacing = 0.sp,
        lineHeight = 16.sp
    )
)