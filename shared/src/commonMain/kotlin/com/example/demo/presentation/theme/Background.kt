package com.example.demo.presentation.theme

import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color

fun Modifier.brandBackground(): Modifier = drawBehind {
    drawRect(color = BrandDark)
    drawRect(
        brush = Brush.radialGradient(
            colors = listOf(BrandOrange.copy(alpha = 0.16f), Color.Transparent),
            center = Offset.Zero,
            radius = size.maxDimension * 0.72f,
        ),
    )
    drawRect(
        brush = Brush.radialGradient(
            colors = listOf(BrandAmber.copy(alpha = 0.12f), Color.Transparent),
            center = Offset(size.width, size.height),
            radius = size.maxDimension * 0.72f,
        ),
    )
}
