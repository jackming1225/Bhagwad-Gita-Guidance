package com.example

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AutoAwesome
import androidx.compose.material.icons.filled.Bookmarks
import androidx.compose.material.icons.filled.SelfImprovement
import androidx.compose.material.icons.filled.WbSunny
import androidx.compose.material.icons.outlined.AutoAwesome
import androidx.compose.material.icons.outlined.Bookmarks
import androidx.compose.material.icons.outlined.SelfImprovement
import androidx.compose.material.icons.outlined.WbSunny
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.ui.components.DakshinaDialog
import com.example.ui.components.GitaDrawerContent
import com.example.ui.components.GitaTopBar
import com.example.ui.components.LanguageSelectorDialog
import com.example.ui.components.UserProfileDialog
import com.example.ui.screens.ChatScreen
import com.example.ui.screens.CollectionScreen
import com.example.ui.screens.DailyDarshanScreen
import com.example.ui.screens.MeditationScreen
import com.example.ui.theme.GitaWisdomTheme
import com.example.ui.util.GitaUiTranslations
import com.example.ui.viewmodel.GitaViewModel
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            GitaWisdomTheme {
                GitaApp()
            }
        }
    }
}

@Composable
fun GitaApp(viewModel: GitaViewModel = viewModel()) {
    val currentTab by viewModel.currentTab.collectAsState()
    val selectedLanguage by viewModel.selectedLanguage.collectAsState()
    val userProfile by viewModel.userProfile.collectAsState()
    val hasAnsweredFirstQuestion by viewModel.hasAnsweredFirstQuestion.collectAsState()

    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val coroutineScope = rememberCoroutineScope()
    val strings = GitaUiTranslations.get(selectedLanguage)

    var showLanguageDialog by remember { mutableStateOf(false) }
    var showProfileDialog by remember { mutableStateOf(false) }
    var showDakshinaDialog by remember { mutableStateOf(false) }

    if (showDakshinaDialog) {
        DakshinaDialog(
            onDismiss = { showDakshinaDialog = false }
        )
    }

    if (showLanguageDialog) {
        LanguageSelectorDialog(
            currentLanguage = selectedLanguage,
            onLanguageSelected = { lang ->
                viewModel.setLanguage(lang)
            },
            onDismiss = { showLanguageDialog = false }
        )
    }

    if (showProfileDialog) {
        UserProfileDialog(
            initialProfile = userProfile,
            selectedLanguage = selectedLanguage,
            onSaveProfile = { updated ->
                viewModel.updateUserProfile(updated)
            },
            onLinkGoogle = { googleUser ->
                viewModel.linkGoogleProfile(googleUser)
            },
            onUnlinkGoogle = {
                viewModel.unlinkGoogleProfile()
            },
            onDismiss = { showProfileDialog = false }
        )
    }

    // Wrap in ModalNavigationDrawer so all options are accessible via Hamburger Menu
    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet(
                drawerContainerColor = MaterialTheme.colorScheme.surface,
                drawerTonalElevation = 2.dp,
                modifier = Modifier.widthIn(max = 320.dp)
            ) {
                GitaDrawerContent(
                    currentTab = currentTab,
                    userProfile = userProfile,
                    selectedLanguage = selectedLanguage,
                    onSelectTab = { tab ->
                        viewModel.selectTab(tab)
                    },
                    onOpenProfile = { showProfileDialog = true },
                    onOpenLanguageSelector = { showLanguageDialog = true },
                    onOpenDakshina = { showDakshinaDialog = true },
                    onClearChat = { viewModel.clearChat() },
                    onCloseDrawer = {
                        coroutineScope.launch { drawerState.close() }
                    }
                )
            }
        }
    ) {
        Scaffold(
            modifier = Modifier.fillMaxSize(),
            topBar = {
                GitaTopBar(
                    selectedLanguage = selectedLanguage,
                    userProfile = userProfile,
                    onOpenMenu = {
                        coroutineScope.launch { drawerState.open() }
                    },
                    onOpenProfile = { showProfileDialog = true },
                    onOpenLanguageSelector = { showLanguageDialog = true },
                    showClearChat = currentTab == 0 && hasAnsweredFirstQuestion,
                    onClearChat = { viewModel.clearChat() }
                )
            },
            bottomBar = {
                // Bottom navigation is hidden on launch and smoothly animates in after the first answer
                AnimatedVisibility(
                    visible = hasAnsweredFirstQuestion || currentTab != 0,
                    enter = slideInVertically(
                        initialOffsetY = { it },
                        animationSpec = spring(
                            dampingRatio = Spring.DampingRatioLowBouncy,
                            stiffness = Spring.StiffnessMediumLow
                        )
                    ) + fadeIn(animationSpec = tween(400, easing = FastOutSlowInEasing)),
                    exit = slideOutVertically(
                        targetOffsetY = { it },
                        animationSpec = tween(300)
                    ) + fadeOut(animationSpec = tween(300))
                ) {
                    NavigationBar(
                        containerColor = MaterialTheme.colorScheme.surface,
                        tonalElevation = 6.dp,
                        modifier = Modifier.testTag("main_navigation_bar")
                    ) {
                        NavigationBarItem(
                            selected = currentTab == 0,
                            onClick = { viewModel.selectTab(0) },
                            icon = {
                                Icon(
                                    imageVector = if (currentTab == 0) Icons.Filled.AutoAwesome else Icons.Outlined.AutoAwesome,
                                    contentDescription = strings.navGuidance
                                )
                            },
                            label = {
                                Text(
                                    text = strings.navGuidance,
                                    fontWeight = if (currentTab == 0) FontWeight.Bold else FontWeight.Normal
                                )
                            },
                            colors = NavigationBarItemDefaults.colors(
                                selectedIconColor = MaterialTheme.colorScheme.primary,
                                selectedTextColor = MaterialTheme.colorScheme.primary,
                                indicatorColor = MaterialTheme.colorScheme.primary.copy(alpha = 0.12f)
                            ),
                            modifier = Modifier.testTag("nav_tab_guidance")
                        )

                        NavigationBarItem(
                            selected = currentTab == 1,
                            onClick = { viewModel.selectTab(1) },
                            icon = {
                                Icon(
                                    imageVector = if (currentTab == 1) Icons.Filled.WbSunny else Icons.Outlined.WbSunny,
                                    contentDescription = strings.navDarshan
                                )
                            },
                            label = {
                                Text(
                                    text = strings.navDarshan,
                                    fontWeight = if (currentTab == 1) FontWeight.Bold else FontWeight.Normal
                                )
                            },
                            colors = NavigationBarItemDefaults.colors(
                                selectedIconColor = MaterialTheme.colorScheme.primary,
                                selectedTextColor = MaterialTheme.colorScheme.primary,
                                indicatorColor = MaterialTheme.colorScheme.primary.copy(alpha = 0.12f)
                            ),
                            modifier = Modifier.testTag("nav_tab_darshan")
                        )

                        NavigationBarItem(
                            selected = currentTab == 2,
                            onClick = { viewModel.selectTab(2) },
                            icon = {
                                Icon(
                                    imageVector = if (currentTab == 2) Icons.Filled.Bookmarks else Icons.Outlined.Bookmarks,
                                    contentDescription = strings.navCollections
                                )
                            },
                            label = {
                                Text(
                                    text = strings.navCollections,
                                    fontWeight = if (currentTab == 2) FontWeight.Bold else FontWeight.Normal
                                )
                            },
                            colors = NavigationBarItemDefaults.colors(
                                selectedIconColor = MaterialTheme.colorScheme.primary,
                                selectedTextColor = MaterialTheme.colorScheme.primary,
                                indicatorColor = MaterialTheme.colorScheme.primary.copy(alpha = 0.12f)
                            ),
                            modifier = Modifier.testTag("nav_tab_collection")
                        )

                        NavigationBarItem(
                            selected = currentTab == 3,
                            onClick = { viewModel.selectTab(3) },
                            icon = {
                                Icon(
                                    imageVector = if (currentTab == 3) Icons.Filled.SelfImprovement else Icons.Outlined.SelfImprovement,
                                    contentDescription = strings.navMeditate
                                )
                            },
                            label = {
                                Text(
                                    text = strings.navMeditate,
                                    fontWeight = if (currentTab == 3) FontWeight.Bold else FontWeight.Normal
                                )
                            },
                            colors = NavigationBarItemDefaults.colors(
                                selectedIconColor = MaterialTheme.colorScheme.primary,
                                selectedTextColor = MaterialTheme.colorScheme.primary,
                                indicatorColor = MaterialTheme.colorScheme.primary.copy(alpha = 0.12f)
                            ),
                            modifier = Modifier.testTag("nav_tab_meditate")
                        )
                    }
                }
            }
        ) { innerPadding ->
            when (currentTab) {
                0 -> ChatScreen(
                    viewModel = viewModel,
                    onOpenProfile = { showProfileDialog = true },
                    onOpenDakshina = { showDakshinaDialog = true },
                    modifier = Modifier.padding(innerPadding)
                )
                1 -> DailyDarshanScreen(
                    viewModel = viewModel,
                    modifier = Modifier.padding(innerPadding)
                )
                2 -> CollectionScreen(
                    viewModel = viewModel,
                    selectedLanguage = selectedLanguage,
                    modifier = Modifier.padding(innerPadding)
                )
                3 -> MeditationScreen(
                    selectedLanguage = selectedLanguage,
                    modifier = Modifier.padding(innerPadding)
                )
            }
        }
    }
}
