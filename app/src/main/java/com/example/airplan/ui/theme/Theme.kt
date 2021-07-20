package com.example.airplan.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable

private val DarkColorPalette = lightColors(
    primary = airplan_dark_800,
    primaryVariant = airplan_dark_gray,
    secondary = airplan_red,
    surface = airplan_dark_900,
    onSurface = airplan_white,
    background = airplan_dark_gray,
)

private val LightColorPalette = lightColors(
    primary = airplan_blue_800,
    primaryVariant = airplan_blue_700,
    secondary = airplan_red,
    surface = airplan_blue_900,
    onSurface = airplan_white,
)

@Composable
fun AiruneTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable() () -> Unit) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}