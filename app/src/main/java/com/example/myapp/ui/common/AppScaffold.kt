package com.example.myapp.ui.common

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.myapp.R
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppScaffold(
    title: String,
    firstName: String,
    lastName: String,
    userRole: String,
    onLogout: () -> Unit,
    onLeaderboardClick: () -> Unit = {},
    content: @Composable (innerPadding: androidx.compose.foundation.layout.PaddingValues) -> Unit
) {
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            DrawerContent(
                firstName = firstName,
                lastName = lastName,
                userRole = userRole,
                onLeaderboardClick = {
                    scope.launch { drawerState.close() }
                    onLeaderboardClick()
                },
                onSettingsClick = {
                    scope.launch { drawerState.close() }
                },
                onLogoutClick = {
                    scope.launch { drawerState.close() }
                    onLogout()
                }
            )
        }
    ) {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = { Text(title) },
                    navigationIcon = {
                        Image(
                            painter = painterResource(id = R.drawable.ic_book),
                            contentDescription = "Logo",
                            colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.primary),
                            modifier = Modifier.size(36.dp)
                        )
                    },
                    actions = {
                        IconButton(onClick = {
                            scope.launch { drawerState.open() }
                        }) {
                            Icon(
                                imageVector = Icons.Default.Menu,
                                contentDescription = "Menu"
                            )
                        }
                    }
                )
            }
        ) { innerPadding ->
            content(innerPadding)
        }
    }
}
