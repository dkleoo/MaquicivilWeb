package com.example.demo.presentation.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val MaquicivilColorScheme = darkColorScheme(
    primary = BrandOrange,
    onPrimary = Color.Black,
    primaryContainer = BrandOrangeDark,
    onPrimaryContainer = Color.Black,
    secondary = BrandAmber,
    onSecondary = Color.Black,
    secondaryContainer = BrandAmber,
    onSecondaryContainer = Color.Black,
    tertiary = BrandYellow,
    onTertiary = Color.Black,
    background = BrandDark,
    onBackground = OnDark,
    surface = SurfacePanel,
    onSurface = OnDark,
    surfaceVariant = SurfaceInput,
    onSurfaceVariant = TextSecondary,
    outline = BorderStrong,
    error = DangerRed,
    onError = Color.Black,
)

@Composable
fun MaquicivilTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colorScheme = MaquicivilColorScheme,
        typography = maquicivilTypography(),
        content = content,
    )
}
