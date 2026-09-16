package com.example.ui.screens

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.Send
import androidx.compose.material.icons.filled.Tune
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.ExperimentalTextApi
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.data.local.ChatMessageEntity
import com.example.data.local.UserProfileEntity
import com.example.data.model.GitaLanguage
import com.example.data.model.LifeTopic
import com.example.ui.components.GeminiBrandBrush
import com.example.ui.components.GeminiSparkle
import com.example.ui.components.GeminiSparkleAvatar
import com.example.ui.components.VerseCard
import com.example.ui.viewmodel.GitaViewModel

@OptIn(ExperimentalTextApi::class)
@Composable
fun ChatScreen(
    viewModel: GitaViewModel,
    onOpenProfile: () -> Unit = {},
    onOpenDakshina: () -> Unit = {},
    modifier: Modifier = Modifier
) {
    val messages by viewModel.chatMessages.collectAsState()
    val isTyping by viewModel.isTyping.collectAsState()
    val selectedLanguage by viewModel.selectedLanguage.collectAsState()
    val favorites by viewModel.favorites.collectAsState()
    val isSpeaking by viewModel.isSpeaking.collectAsState()
    val currentUtteranceId by viewModel.currentUtteranceId.collectAsState()
    val userProfile by viewModel.userProfile.collectAsState()
    val hasAnsweredFirstQuestion by viewModel.hasAnsweredFirstQuestion.collectAsState()

    var inputText by remember { mutableStateOf("") }
    val listState = rememberLazyListState()

    // Determine if we should show the clean "Ask User Need" view on launch
    val hasUserMessages = messages.any { it.isUser }
    val showMinimalNeedView = !hasAnsweredFirstQuestion && !isTyping

    LaunchedEffect(messages.size, isTyping) {
        if (messages.isNotEmpty()) {
            listState.animateScrollToItem(messages.size - 1)
        }
    }

    Box(
        modifier = modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ) {
        if (showMinimalNeedView) {
            // Clean Minimalist View on Every Launch: Just Ask the Need from User
            AskNeedHomeScreen(
                userProfile = userProfile,
                selectedLanguage = selectedLanguage,
                inputText = inputText,
                hasPastMessages = hasUserMessages,
                pastMessagesCount = messages.count { it.isUser },
                onViewPastMessages = { viewModel.revealConversation() },
                onInputTextChanged = { inputText = it },
                onSend = { query ->
                    viewModel.sendMessage(query)
                    inputText = ""
                },
                onSelectTopic = { topic ->
                    viewModel.askAboutTopic(topic)
                },
                onOpenProfile = onOpenProfile
            )
        } else {
            // Conversational Dialogue Stream
            Column(modifier = Modifier.fillMaxSize()) {
                LazyColumn(
                    state = listState,
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp),
                    verticalArrangement = Arrangement.spacedBy(16.dp),
                    contentPadding = PaddingValues(top = 12.dp, bottom = 16.dp)
                ) {
                    item {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(vertical = 4.dp),
                            horizontalArrangement = Arrangement.Center
                        ) {
                            Surface(
                                shape = RoundedCornerShape(16.dp),
                                color = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.5f),
                                modifier = Modifier
                                    .clip(RoundedCornerShape(16.dp))
                                    .clickable { viewModel.hideConversation() }
                                    .testTag("back_to_guidance_button")
                            ) {
                                Row(
                                    modifier = Modifier.padding(horizontal = 14.dp, vertical = 7.dp),
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    Text(
                                        text = "✨ Return to Ask Need",
                                        style = MaterialTheme.typography.bodySmall,
                                        color = MaterialTheme.colorScheme.primary,
                                        fontWeight = FontWeight.SemiBold
                                    )
                                }
                            }
                        }
                    }

                    items(messages) { message ->
                        ChatMessageItem(
                            message = message,
                            userProfile = userProfile,
                            isFavorited = favorites.any { it.citation == message.verseCitation },
                            isSpeaking = isSpeaking && currentUtteranceId == "msg_${message.id}",
                            onToggleFavorite = {
                                val citation = message.verseCitation ?: return@ChatMessageItem
                                val sanskrit = message.verseSanskrit ?: ""
                                val transliteration = message.verseTransliteration ?: ""
                                val translation = message.verseTranslation ?: message.messageText
                                viewModel.toggleFavorite(
                                    citation = citation,
                                    sanskrit = sanskrit,
                                    transliteration = transliteration,
                                    translation = translation,
                                    theme = "Gita Guidance"
                                )
                            },
                            onPlayAudio = {
                                val audioText = if (!message.verseSanskrit.isNullOrBlank()) {
                                    "${message.verseSanskrit}. ${message.verseTranslation ?: ""}. ${message.lifeGuidance ?: ""}"
                                } else {
                                    message.messageText
                                }
                                viewModel.speakVerse(audioText, "msg_${message.id}")
                            },
                            onStopAudio = { viewModel.stopSpeaking() },
                            onOpenDakshina = onOpenDakshina
                        )
                    }

                    if (isTyping) {
                        item {
                            GeminiTypingIndicator(userName = userProfile.name)
                        }
                    }
                }

                // Bottom Floating Gemini Dock
                ChatBottomInputDock(
                    inputText = inputText,
                    onInputTextChanged = { inputText = it },
                    isTyping = isTyping,
                    selectedLanguage = selectedLanguage,
                    userProfile = userProfile,
                    onSend = { query ->
                        viewModel.sendMessage(query)
                        inputText = ""
                    },
                    onOpenProfile = onOpenProfile
                )
            }
        }
    }
}

/**
 * Minimal, serene home screen on launch that asks the user's need directly without clutter.
 */
@OptIn(ExperimentalLayoutApi::class)
@Composable
fun AskNeedHomeScreen(
    userProfile: UserProfileEntity,
    selectedLanguage: GitaLanguage,
    inputText: String,
    hasPastMessages: Boolean = false,
    pastMessagesCount: Int = 0,
    onViewPastMessages: () -> Unit = {},
    onInputTextChanged: (String) -> Unit,
    onSend: (String) -> Unit,
    onSelectTopic: (LifeTopic) -> Unit,
    onOpenProfile: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(horizontal = 24.dp, vertical = 20.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        // Divine Glowing Sparkle Emblem
        Box(
            modifier = Modifier
                .size(72.dp)
                .clip(CircleShape)
                .background(MaterialTheme.colorScheme.primary.copy(alpha = 0.1f)),
            contentAlignment = Alignment.Center
        ) {
            GeminiSparkle(size = 46.dp, animated = true)
        }

        Spacer(modifier = Modifier.height(20.dp))

        // Greeting with seeker's name
        Text(
            text = "Namaste, ${userProfile.name.ifBlank { "Seeker" }}",
            style = TextStyle(
                brush = GeminiBrandBrush,
                fontSize = 28.sp,
                fontWeight = FontWeight.Bold,
                letterSpacing = (-0.5).sp
            ),
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(8.dp))

        // Prompt asking the need
        Text(
            text = when (selectedLanguage) {
                GitaLanguage.HINDI -> "आज आपके मन में क्या प्रश्न अथवा दुविधा है?"
                GitaLanguage.SANSKRIT -> "अद्य तव मनसि कः संशयः वर्तते?"
                else -> "What guidance do you seek today?"
            },
            style = MaterialTheme.typography.headlineSmall,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.onSurface,
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(10.dp))

        Text(
            text = "Share any struggle with duty, peace of mind, fear, or relationships. Krishna's timeless wisdom will guide you.",
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onSurfaceVariant,
            textAlign = TextAlign.Center,
            lineHeight = 22.sp,
            modifier = Modifier.widthIn(max = 380.dp)
        )

        Spacer(modifier = Modifier.height(28.dp))

        // Focused Input Card
        Surface(
            shape = RoundedCornerShape(26.dp),
            color = MaterialTheme.colorScheme.surface,
            tonalElevation = 4.dp,
            shadowElevation = 3.dp,
            border = BorderStroke(
                1.5.dp,
                MaterialTheme.colorScheme.primary.copy(alpha = 0.25f)
            ),
            modifier = Modifier
                .fillMaxWidth()
                .widthIn(max = 500.dp)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 14.dp, vertical = 6.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                OutlinedTextField(
                    value = inputText,
                    onValueChange = onInputTextChanged,
                    placeholder = {
                        Text(
                            text = when (selectedLanguage) {
                                GitaLanguage.HINDI -> "अपनी दुविधा या प्रश्न लिखें..."
                                GitaLanguage.SANSKRIT -> "संशयं लिखतु..."
                                else -> "Type your question or dilemma..."
                            },
                            style = MaterialTheme.typography.bodyMedium,
                            color = MaterialTheme.colorScheme.onSurfaceVariant.copy(alpha = 0.65f)
                        )
                    },
                    modifier = Modifier
                        .weight(1f)
                        .testTag("chat_input_field"),
                    shape = RoundedCornerShape(20.dp),
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedBorderColor = Color.Transparent,
                        unfocusedBorderColor = Color.Transparent,
                        focusedContainerColor = Color.Transparent,
                        unfocusedContainerColor = Color.Transparent
                    ),
                    maxLines = 3,
                    keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Send),
                    keyboardActions = KeyboardActions(
                        onSend = {
                            if (inputText.isNotBlank()) {
                                onSend(inputText)
                            }
                        }
                    )
                )

                val canSend = inputText.isNotBlank()
                IconButton(
                    onClick = {
                        if (canSend) {
                            onSend(inputText)
                        }
                    },
                    enabled = canSend,
                    modifier = Modifier
                        .size(46.dp)
                        .clip(CircleShape)
                        .background(
                            if (canSend) MaterialTheme.colorScheme.primary
                            else MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.5f)
                        )
                        .testTag("send_button")
                ) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.Send,
                        contentDescription = "Send",
                        tint = if (canSend) Color.White else MaterialTheme.colorScheme.onSurfaceVariant.copy(alpha = 0.4f),
                        modifier = Modifier.size(20.dp)
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        // Clean, minimal prompt chips
        Text(
            text = "Or tap to explore common dilemmas:",
            style = MaterialTheme.typography.labelSmall,
            color = MaterialTheme.colorScheme.onSurfaceVariant,
            fontWeight = FontWeight.Medium
        )

        Spacer(modifier = Modifier.height(12.dp))

        FlowRow(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            LifeTopic.ALL.take(4).forEach { topic ->
                Surface(
                    shape = RoundedCornerShape(20.dp),
                    color = MaterialTheme.colorScheme.surface,
                    tonalElevation = 1.dp,
                    border = BorderStroke(
                        1.dp,
                        MaterialTheme.colorScheme.outline.copy(alpha = 0.15f)
                    ),
                    modifier = Modifier
                        .padding(horizontal = 4.dp)
                        .clip(RoundedCornerShape(20.dp))
                        .clickable { onSelectTopic(topic) }
                        .testTag("topic_chip_${topic.id}")
                ) {
                    Row(
                        modifier = Modifier.padding(horizontal = 14.dp, vertical = 8.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = when (topic.id) {
                                "work_stress" -> "💼 "
                                "overthinking" -> "🕊️ "
                                "anger" -> "🧘 "
                                else -> "🎯 "
                            } + topic.title,
                            style = MaterialTheme.typography.labelMedium,
                            fontWeight = FontWeight.SemiBold,
                            color = MaterialTheme.colorScheme.onSurface
                        )
                    }
                }
            }
        }

        if (hasPastMessages && pastMessagesCount > 0) {
            Spacer(modifier = Modifier.height(14.dp))
            Surface(
                shape = RoundedCornerShape(16.dp),
                color = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.35f),
                modifier = Modifier
                    .clip(RoundedCornerShape(16.dp))
                    .clickable { onViewPastMessages() }
                    .testTag("view_past_messages_button")
            ) {
                Row(
                    modifier = Modifier.padding(horizontal = 14.dp, vertical = 7.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "📜 View previous conversation ($pastMessagesCount ${if (pastMessagesCount == 1) "inquiry" else "inquiries"})",
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.primary,
                        fontWeight = FontWeight.SemiBold
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(20.dp))

        // Shri Krishna is online indicator
        Surface(
            shape = RoundedCornerShape(16.dp),
            color = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.5f),
            border = BorderStroke(1.dp, Color(0xFF4CAF50).copy(alpha = 0.3f)),
            modifier = Modifier
                .testTag("home_online_chip")
        ) {
            Row(
                modifier = Modifier.padding(horizontal = 14.dp, vertical = 7.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    modifier = Modifier
                        .size(8.dp)
                        .clip(CircleShape)
                        .background(Color(0xFF4CAF50))
                )
                Spacer(modifier = Modifier.width(7.dp))
                Text(
                    text = "Shri Krishna is online",
                    style = MaterialTheme.typography.labelSmall,
                    fontWeight = FontWeight.SemiBold,
                    color = MaterialTheme.colorScheme.onSurface
                )
            }
        }
    }
}

/**
 * Bottom Floating Input Dock for ongoing conversation
 */
@Composable
fun ChatBottomInputDock(
    inputText: String,
    onInputTextChanged: (String) -> Unit,
    isTyping: Boolean,
    selectedLanguage: GitaLanguage,
    userProfile: UserProfileEntity,
    onSend: (String) -> Unit,
    onOpenProfile: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp)
    ) {
        Surface(
            shape = RoundedCornerShape(28.dp),
            color = MaterialTheme.colorScheme.surface,
            tonalElevation = 3.dp,
            shadowElevation = 2.dp,
            border = BorderStroke(
                1.dp,
                MaterialTheme.colorScheme.outline.copy(alpha = 0.15f)
            ),
            modifier = Modifier.fillMaxWidth()
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 12.dp, vertical = 4.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    modifier = Modifier
                        .size(36.dp)
                        .clip(CircleShape)
                        .background(MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.5f)),
                    contentAlignment = Alignment.Center
                ) {
                    GeminiSparkle(size = 20.dp, animated = isTyping)
                }

                Spacer(modifier = Modifier.width(8.dp))

                OutlinedTextField(
                    value = inputText,
                    onValueChange = onInputTextChanged,
                    placeholder = {
                        Text(
                            text = when (selectedLanguage) {
                                GitaLanguage.HINDI -> "कृष्ण से प्रश्न पूछें..."
                                GitaLanguage.SANSKRIT -> "जीवने संशयं पृच्छतु..."
                                else -> "Ask Krishna anything..."
                            },
                            style = MaterialTheme.typography.bodyMedium,
                            color = MaterialTheme.colorScheme.onSurfaceVariant.copy(alpha = 0.6f)
                        )
                    },
                    modifier = Modifier
                        .weight(1f)
                        .testTag("chat_input_field"),
                    shape = RoundedCornerShape(20.dp),
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedBorderColor = Color.Transparent,
                        unfocusedBorderColor = Color.Transparent,
                        focusedContainerColor = Color.Transparent,
                        unfocusedContainerColor = Color.Transparent
                    ),
                    maxLines = 4,
                    keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Send),
                    keyboardActions = KeyboardActions(
                        onSend = {
                            if (inputText.isNotBlank() && !isTyping) {
                                onSend(inputText)
                            }
                        }
                    )
                )

                val canSend = inputText.isNotBlank() && !isTyping
                IconButton(
                    onClick = {
                        if (canSend) {
                            onSend(inputText)
                        }
                    },
                    enabled = canSend,
                    modifier = Modifier
                        .size(42.dp)
                        .clip(CircleShape)
                        .background(
                            if (canSend) MaterialTheme.colorScheme.primary
                            else MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.5f)
                        )
                        .testTag("send_button")
                ) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.Send,
                        contentDescription = "Send Question",
                        tint = if (canSend) Color.White else MaterialTheme.colorScheme.onSurfaceVariant.copy(alpha = 0.4f),
                        modifier = Modifier.size(18.dp)
                    )
                }
            }
        }
    }
}

@Composable
fun ChatMessageItem(
    message: ChatMessageEntity,
    userProfile: UserProfileEntity,
    isFavorited: Boolean,
    isSpeaking: Boolean,
    onToggleFavorite: () -> Unit,
    onPlayAudio: () -> Unit,
    onStopAudio: () -> Unit,
    onOpenDakshina: () -> Unit = {}
) {
    if (message.isUser) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.End
        ) {
            Surface(
                shape = RoundedCornerShape(
                    topStart = 20.dp,
                    topEnd = 6.dp,
                    bottomStart = 20.dp,
                    bottomEnd = 20.dp
                ),
                color = MaterialTheme.colorScheme.primary,
                modifier = Modifier
                    .widthIn(max = 310.dp)
                    .testTag("user_message_${message.id}")
            ) {
                Text(
                    text = message.messageText,
                    style = MaterialTheme.typography.bodyMedium.copy(
                        color = Color.White,
                        lineHeight = 22.sp
                    ),
                    modifier = Modifier.padding(horizontal = 16.dp, vertical = 12.dp)
                )
            }
        }
    } else {
        val hasDakshina = !message.isUser && (
            message.messageText.contains("A Note on Dakshina", ignoreCase = true) ||
            message.messageText.contains("Dakshina Dialog", ignoreCase = true) ||
            message.messageText.contains("[Trigger: Show Dakshina Dialog", ignoreCase = true)
        )

        val displayText = if (hasDakshina) {
            message.messageText
                .substringBefore("\n---")
                .substringBefore("---")
                .substringBefore("🪔 *A Note on Dakshina*")
                .substringBefore("[Trigger:")
                .trim()
                .ifBlank { message.messageText }
        } else {
            message.messageText
        }

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Start
        ) {
            GeminiSparkleAvatar(
                size = 32.dp,
                modifier = Modifier.padding(top = 2.dp)
            )

            Spacer(modifier = Modifier.width(10.dp))

            Column(modifier = Modifier.weight(1f)) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.padding(bottom = 4.dp)
                ) {
                    Text(
                        text = "Krishna AI",
                        style = MaterialTheme.typography.labelMedium,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.onSurface
                    )
                    Spacer(modifier = Modifier.width(6.dp))
                    Text(
                        text = "for ${userProfile.name}",
                        style = MaterialTheme.typography.labelSmall,
                        color = MaterialTheme.colorScheme.onSurfaceVariant,
                        fontSize = 11.sp
                    )
                }

                Surface(
                    shape = RoundedCornerShape(
                        topStart = 4.dp,
                        topEnd = 20.dp,
                        bottomStart = 20.dp,
                        bottomEnd = 20.dp
                    ),
                    color = MaterialTheme.colorScheme.surface,
                    tonalElevation = 1.dp,
                    border = BorderStroke(
                        1.dp,
                        MaterialTheme.colorScheme.outline.copy(alpha = 0.12f)
                    ),
                    modifier = Modifier.testTag("bot_message_${message.id}")
                ) {
                    Column(modifier = Modifier.padding(14.dp)) {
                        Text(
                            text = displayText,
                            style = MaterialTheme.typography.bodyMedium.copy(
                                lineHeight = 22.sp,
                                color = MaterialTheme.colorScheme.onSurface
                            )
                        )

                        if (!message.verseCitation.isNullOrBlank() && !message.verseSanskrit.isNullOrBlank()) {
                            Spacer(modifier = Modifier.height(12.dp))
                            VerseCard(
                                citation = message.verseCitation,
                                sanskrit = message.verseSanskrit,
                                transliteration = message.verseTransliteration,
                                translation = message.verseTranslation ?: "",
                                theme = "Guiding Verse",
                                isFavorited = isFavorited,
                                isSpeaking = isSpeaking,
                                onToggleFavorite = onToggleFavorite,
                                onPlayAudio = onPlayAudio,
                                onStopAudio = onStopAudio
                            )
                        }

                        if (!message.lifeGuidance.isNullOrBlank() && message.verseCitation.isNullOrBlank()) {
                            Spacer(modifier = Modifier.height(8.dp))
                            Surface(
                                shape = RoundedCornerShape(12.dp),
                                color = MaterialTheme.colorScheme.primary.copy(alpha = 0.08f),
                                modifier = Modifier.fillMaxWidth()
                            ) {
                                Column(modifier = Modifier.padding(10.dp)) {
                                    Text(
                                        text = "💡 Contemplation for ${userProfile.name}:",
                                        style = MaterialTheme.typography.labelSmall,
                                        fontWeight = FontWeight.Bold,
                                        color = MaterialTheme.colorScheme.primary
                                    )
                                    Spacer(modifier = Modifier.height(4.dp))
                                    Text(
                                        text = message.lifeGuidance,
                                        style = MaterialTheme.typography.bodySmall,
                                        color = MaterialTheme.colorScheme.onSurface
                                    )
                                }
                            }
                        }

                        // Dakshina Footer Card when triggered
                        if (hasDakshina) {
                            Spacer(modifier = Modifier.height(14.dp))
                            HorizontalDivider(
                                color = Color(0xFFFFB300).copy(alpha = 0.35f),
                                thickness = 1.dp
                            )
                            Spacer(modifier = Modifier.height(12.dp))
                            DakshinaNoteCard(
                                onOfferDakshina = onOpenDakshina
                            )
                        }
                    }
                }
            }
        }
    }
}

/**
 * Sacred Dakshina note component honoring Indian tradition and voluntary support.
 */
@Composable
fun DakshinaNoteCard(
    onOfferDakshina: () -> Unit
) {
    Surface(
        shape = RoundedCornerShape(14.dp),
        color = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.45f),
        border = BorderStroke(1.dp, Color(0xFFFFB300).copy(alpha = 0.35f)),
        modifier = Modifier
            .fillMaxWidth()
            .testTag("dakshina_note_card")
    ) {
        Column(modifier = Modifier.padding(14.dp)) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(text = "🪔", fontSize = 18.sp)
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = "A Note on Dakshina",
                    style = MaterialTheme.typography.titleSmall,
                    fontWeight = FontWeight.Bold,
                    fontStyle = FontStyle.Italic,
                    color = MaterialTheme.colorScheme.onSurface
                )
            }

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "This platform is sustained through the voluntary love and generosity of fellow seekers. If this reflection brought clarity to your heart today, you are warmly invited to offer a modest Dakshina to support our hosting costs and keep this guidance freely accessible to all.",
                style = MaterialTheme.typography.bodySmall.copy(lineHeight = 19.sp),
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )

            Spacer(modifier = Modifier.height(12.dp))

            Button(
                onClick = onOfferDakshina,
                shape = RoundedCornerShape(12.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = MaterialTheme.colorScheme.primary
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(44.dp)
                    .testTag("trigger_dakshina_button")
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    Text(text = "🪔", fontSize = 16.sp)
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        text = "Offer Dakshina (Support the Seva)",
                        style = MaterialTheme.typography.labelLarge,
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                    )
                }
            }
        }
    }
}

@Composable
fun GeminiTypingIndicator(userName: String) {
    val infiniteTransition = rememberInfiniteTransition(label = "pulse")
    val alpha by infiniteTransition.animateFloat(
        initialValue = 0.4f,
        targetValue = 1f,
        animationSpec = infiniteRepeatable(
            animation = tween(700, easing = FastOutSlowInEasing),
            repeatMode = RepeatMode.Reverse
        ),
        label = "alpha"
    )

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .testTag("typing_indicator"),
        horizontalArrangement = Arrangement.Start,
        verticalAlignment = Alignment.CenterVertically
    ) {
        GeminiSparkleAvatar(size = 30.dp)

        Spacer(modifier = Modifier.width(10.dp))

        Surface(
            shape = RoundedCornerShape(18.dp),
            color = MaterialTheme.colorScheme.surface,
            tonalElevation = 2.dp,
            border = BorderStroke(
                1.dp,
                MaterialTheme.colorScheme.primary.copy(alpha = 0.25f)
            )
        ) {
            Row(
                modifier = Modifier.padding(horizontal = 14.dp, vertical = 8.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                GeminiSparkle(size = 14.dp, animated = true)
                Text(
                    text = "Shri Krishna is contemplating eternal counsel...",
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.primary.copy(alpha = alpha),
                    fontWeight = FontWeight.Medium
                )
            }
        }
    }
}
