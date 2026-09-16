package com.example.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val DarkColorScheme = darkColorScheme(
    primary = SpiritualDarkPrimary,
    onPrimary = Color(0xFF3E1200),
    primaryContainer = Color(0xFF661E00),
    onPrimaryContainer = Color(0xFFFFDBCF),
    secondary = SpiritualDarkGold,
    onSecondary = Color(0xFF422B00),
    secondaryContainer = Color(0xFF5E3F00),
    onSecondaryContainer = Color(0xFFFFDEA3),
    tertiary = GoldenAmber,
    background = SpiritualDarkBg,
    onBackground = TextPrimaryLight,
    surface = SpiritualDarkSurface,
    onSurface = TextPrimaryLight,
    surfaceVariant = SpiritualDarkCard,
    onSurfaceVariant = TextSecondaryLight
)

private val LightColorScheme = lightColorScheme(
    primary = SaffronPrimary,
    onPrimary = Color.White,
    primaryContainer = SoftGoldBg,
    onPrimaryContainer = SacredMaroon,
    secondary = SaffronSecondary,
    onSecondary = Color.White,
    secondaryContainer = Color(0xFFFFECB3),
    onSecondaryContainer = Color(0xFF5D3F00),
    tertiary = GoldenAmber,
    background = WarmParchment,
    onBackground = TextPrimaryDark,
    surface = TempleIvory,
    onSurface = TextPrimaryDark,
    surfaceVariant = Color(0xFFF7EFE2),
    onSurfaceVariant = TextSecondaryDark
)

@Composable
fun GitaWisdomTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colorScheme = if (darkTheme) DarkColorScheme else LightColorScheme

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}
