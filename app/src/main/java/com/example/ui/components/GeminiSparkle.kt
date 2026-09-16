package com.example.ui.components

import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

// Gemini-inspired vibrant iridescent gradient colors
val GeminiBlue = Color(0xFF4285F4)
val GeminiPurple = Color(0xFF9B51E0)
val GeminiAmber = Color(0xFFF59E0B)
val GeminiCoral = Color(0xFFE65100)
val GitaGold = Color(0xFFFFD54F)

val GeminiBrandBrush = Brush.linearGradient(
    colors = listOf(GeminiBlue, GeminiPurple, GeminiCoral, GeminiAmber)
)

val GitaDivineBrush = Brush.linearGradient(
    colors = listOf(Color(0xFFE65100), Color(0xFFF59E0B), Color(0xFF9C27B0))
)

val GeminiPillBgLight = Color(0xFFF0F4F9)
val GeminiPillBgDark = Color(0xFF1E1F20)
val GeminiCardBgLight = Color(0xFFF8FAFD)
val GeminiCardBgDark = Color(0xFF1E2124)

/**
 * Draws the iconic Gemini 4-pointed curved sparkle using quadratic Bézier curves.
 */
@Composable
fun GeminiSparkle(
    modifier: Modifier = Modifier,
    size: Dp = 24.dp,
    brush: Brush = GeminiBrandBrush,
    animated: Boolean = false
) {
    val scale = if (animated) {
        val infiniteTransition = rememberInfiniteTransition(label = "sparkle_pulse")
        val animatedScale by infiniteTransition.animateFloat(
            initialValue = 0.92f,
            targetValue = 1.08f,
            animationSpec = infiniteRepeatable(
                animation = tween(1200, easing = FastOutSlowInEasing),
                repeatMode = RepeatMode.Reverse
            ),
            label = "scale"
        )
        animatedScale
    } else 1f

    Canvas(
        modifier = modifier
            .size(size)
            .scale(scale)
    ) {
        val w = this.size.width
        val h = this.size.height
        val cx = w / 2f
        val cy = h / 2f

        // Control point inset factor (concavity of the 4-point star)
        val insetFactor = 0.22f

        val path = Path().apply {
            // Top point
            moveTo(cx, 0f)
            // Curve to right point
            quadraticBezierTo(cx + w * insetFactor, cy - h * insetFactor, w, cy)
            // Curve to bottom point
            quadraticBezierTo(cx + w * insetFactor, cy + h * insetFactor, cx, h)
            // Curve to left point
            quadraticBezierTo(cx - w * insetFactor, cy + h * insetFactor, 0f, cy)
            // Curve back to top point
            quadraticBezierTo(cx - w * insetFactor, cy - h * insetFactor, cx, 0f)
            close()
        }

        drawPath(path = path, brush = brush)
    }
}

/**
 * Small circular avatar badge with the Gemini Sparkle icon inside, for bot messages.
 */
@Composable
fun GeminiSparkleAvatar(
    modifier: Modifier = Modifier,
    size: Dp = 32.dp
) {
    Box(
        modifier = modifier
            .size(size)
            .clip(CircleShape)
            .background(Color(0xFF2B2018).copy(alpha = 0.08f)),
        contentAlignment = Alignment.Center
    ) {
        GeminiSparkle(size = size * 0.65f, brush = GeminiBrandBrush)
    }
}
