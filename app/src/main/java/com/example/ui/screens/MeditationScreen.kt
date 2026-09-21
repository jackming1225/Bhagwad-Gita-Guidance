package com.example.ui.screens

import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Pause
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material.icons.filled.SelfImprovement
import androidx.compose.material.icons.filled.Spa
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.FilledIconButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedIconButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.data.model.GitaLanguage
import com.example.ui.util.GitaUiTranslations
import kotlinx.coroutines.delay

enum class BreathPhase(val durationMs: Long) {
    INHALE(4000L),
    HOLD_IN(4000L),
    EXHALE(4000L),
    HOLD_OUT(2000L)
}

@Composable
fun MeditationScreen(
    selectedLanguage: GitaLanguage = GitaLanguage.ENGLISH,
    modifier: Modifier = Modifier
) {
    val strings = GitaUiTranslations.get(selectedLanguage)

    var isRunning by remember { mutableStateOf(false) }
    var phaseIndex by remember { mutableIntStateOf(0) }
    var selectedDurationMinutes by remember { mutableIntStateOf(3) }
    var secondsRemaining by remember { mutableIntStateOf(3 * 60) }

    val phases = BreathPhase.entries
    val currentPhase = phases[phaseIndex]

    val phaseInstruction = when (currentPhase) {
        BreathPhase.INHALE -> strings.breathInhale
        BreathPhase.HOLD_IN -> strings.breathHold
        BreathPhase.EXHALE -> strings.breathExhale
        BreathPhase.HOLD_OUT -> strings.breathRest
    }

    val phaseMantra = when (currentPhase) {
        BreathPhase.INHALE -> strings.breathInhaleSub
        BreathPhase.HOLD_IN -> strings.breathHoldSub
        BreathPhase.EXHALE -> strings.breathExhaleSub
        BreathPhase.HOLD_OUT -> strings.breathRestSub
    }

    // Breathing circle scale animation
    val targetScale = when (currentPhase) {
        BreathPhase.INHALE -> 1.0f
        BreathPhase.HOLD_IN -> 1.0f
        BreathPhase.EXHALE -> 0.45f
        BreathPhase.HOLD_OUT -> 0.45f
    }

    val animatedScale by animateFloatAsState(
        targetValue = if (isRunning) targetScale else 0.7f,
        animationSpec = tween(
            durationMillis = if (isRunning) currentPhase.durationMs.toInt() else 800,
            easing = if (currentPhase == BreathPhase.INHALE || currentPhase == BreathPhase.EXHALE) FastOutSlowInEasing else LinearEasing
        ),
        label = "breath_scale"
    )

    // Timer & Breathing loop
    LaunchedEffect(isRunning, phaseIndex) {
        if (isRunning && secondsRemaining > 0) {
            delay(currentPhase.durationMs)
            phaseIndex = (phaseIndex + 1) % phases.size
        }
    }

    LaunchedEffect(isRunning) {
        while (isRunning && secondsRemaining > 0) {
            delay(1000L)
            secondsRemaining--
            if (secondsRemaining <= 0) {
                isRunning = false
            }
        }
    }

    val gitaAffirmations = listOf(
        "“The soul is never born, nor does it ever die. You are eternal, beyond all worry.” — BG 2.20",
        "“You have the right to work, but never to the fruits of work. Act with freedom.” — BG 2.47",
        "“Like the ocean that remains calm as rivers flow in, remain undisturbed by desire.” — BG 2.70",
        "“Elevate yourself by your own mind. The disciplined mind is your truest friend.” — BG 6.5",
        "“For one who surrenders with devotion, I carry their burdens and protect them.” — BG 9.22"
    )

    var currentAffirmationIndex by remember { mutableIntStateOf(0) }

    LaunchedEffect(isRunning) {
        while (isRunning) {
            delay(14000L)
            currentAffirmationIndex = (currentAffirmationIndex + 1) % gitaAffirmations.size
        }
    }

    val scrollState = rememberScrollState()

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .verticalScroll(scrollState)
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        // Title
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(
                text = strings.meditationTitle,
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.onSurface
            )
            Text(
                text = strings.meditationSubtitle,
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }

        // Duration selector chips
        Row(
            horizontalArrangement = Arrangement.spacedBy(10.dp),
            modifier = Modifier.padding(vertical = 4.dp)
        ) {
            listOf(1, 3, 5).forEach { mins ->
                val isSelected = selectedDurationMinutes == mins
                Surface(
                    shape = RoundedCornerShape(16.dp),
                    color = if (isSelected) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.surface,
                    border = androidx.compose.foundation.BorderStroke(
                        1.dp,
                        if (isSelected) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.outline.copy(alpha = 0.3f)
                    ),
                    modifier = Modifier
                        .clip(RoundedCornerShape(16.dp))
                        .clickable(enabled = !isRunning) {
                            selectedDurationMinutes = mins
                            secondsRemaining = mins * 60
                        }
                        .testTag("timer_chip_${mins}m")
                ) {
                    Text(
                        text = "$mins m",
                        style = MaterialTheme.typography.labelMedium,
                        fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Medium,
                        color = if (isSelected) Color.White else MaterialTheme.colorScheme.onSurface,
                        modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
                    )
                }
            }
        }

        // Breathing Circle Visualizer
        Box(
            modifier = Modifier
                .size(260.dp)
                .testTag("breathing_circle_container"),
            contentAlignment = Alignment.Center
        ) {
            val primaryColor = MaterialTheme.colorScheme.primary
            val tertiaryColor = MaterialTheme.colorScheme.secondary

            Canvas(modifier = Modifier.fillMaxSize()) {
                val center = this.center
                val maxRadius = size.minDimension / 2f
                val currentRadius = maxRadius * animatedScale

                // Outer sacred mandala rings
                drawCircle(
                    color = primaryColor.copy(alpha = 0.08f),
                    radius = maxRadius,
                    style = Stroke(width = 2.dp.toPx())
                )
                drawCircle(
                    color = primaryColor.copy(alpha = 0.15f),
                    radius = maxRadius * 0.75f,
                    style = Stroke(width = 1.5.dp.toPx())
                )

                // Expanding breathing aura
                drawCircle(
                    brush = Brush.radialGradient(
                        colors = listOf(
                            primaryColor.copy(alpha = 0.45f),
                            tertiaryColor.copy(alpha = 0.2f),
                            Color.Transparent
                        ),
                        center = center,
                        radius = currentRadius
                    ),
                    radius = currentRadius,
                    center = center
                )

                drawCircle(
                    color = primaryColor.copy(alpha = 0.85f),
                    radius = currentRadius,
                    style = Stroke(width = 3.dp.toPx())
                )
            }

            // Center Content: Om / Instruction
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.padding(horizontal = 24.dp)
            ) {
                Text(
                    text = "ॐ",
                    fontSize = 38.sp,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.primary
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = if (isRunning) phaseInstruction else strings.startMeditation,
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onSurface,
                    textAlign = TextAlign.Center
                )
                if (isRunning) {
                    Text(
                        text = phaseMantra,
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.onSurfaceVariant,
                        fontSize = 11.sp,
                        textAlign = TextAlign.Center
                    )
                }
            }
        }

        // Remaining Timer
        val minutes = secondsRemaining / 60
        val seconds = secondsRemaining % 60
        Text(
            text = String.format("%02d:%02d", minutes, seconds),
            style = MaterialTheme.typography.headlineMedium,
            fontWeight = FontWeight.SemiBold,
            color = MaterialTheme.colorScheme.primary,
            letterSpacing = 1.sp
        )

        // Play / Pause / Reset Controls
        Row(
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            OutlinedIconButton(
                onClick = {
                    isRunning = false
                    secondsRemaining = selectedDurationMinutes * 60
                    phaseIndex = 0
                },
                modifier = Modifier
                    .size(48.dp)
                    .testTag("reset_meditation_button")
            ) {
                Icon(
                    imageVector = Icons.Default.Refresh,
                    contentDescription = strings.resetMeditation,
                    tint = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }

            FilledIconButton(
                onClick = {
                    if (secondsRemaining <= 0) {
                        secondsRemaining = selectedDurationMinutes * 60
                    }
                    isRunning = !isRunning
                },
                colors = IconButtonDefaults.filledIconButtonColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    contentColor = Color.White
                ),
                modifier = Modifier
                    .size(64.dp)
                    .testTag("toggle_meditation_button")
            ) {
                Icon(
                    imageVector = if (isRunning) Icons.Default.Pause else Icons.Default.PlayArrow,
                    contentDescription = if (isRunning) strings.pauseMeditation else strings.startMeditation,
                    modifier = Modifier.size(32.dp)
                )
            }
        }

        // Contemplative Gita Truth Banner
        Card(
            shape = RoundedCornerShape(20.dp),
            colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
            border = androidx.compose.foundation.BorderStroke(
                1.dp,
                MaterialTheme.colorScheme.primary.copy(alpha = 0.2f)
            ),
            elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.dp)
        ) {
            Column(
                modifier = Modifier.padding(18.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = strings.contemplationPrompt,
                    style = MaterialTheme.typography.labelMedium,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.primary
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = gitaAffirmations[currentAffirmationIndex],
                    style = MaterialTheme.typography.bodyMedium.copy(
                        lineHeight = 22.sp,
                        fontStyle = androidx.compose.ui.text.font.FontStyle.Italic
                    ),
                    textAlign = TextAlign.Center,
                    color = MaterialTheme.colorScheme.onSurface
                )
            }
        }
    }
}
