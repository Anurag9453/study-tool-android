package com.example.myapp.ui.common

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.Logout
import androidx.compose.material.icons.filled.Leaderboard
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun DrawerContent(
    firstName: String,
    lastName: String,
    userRole: String,
    onLeaderboardClick: () -> Unit,
    onSettingsClick: () -> Unit,
    onLogoutClick: () -> Unit
) {
    ModalDrawerSheet(modifier = Modifier.width(300.dp)) {
        // User profile header
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(MaterialTheme.colorScheme.primaryContainer)
                .padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Avatar with initials
            Box(
                modifier = Modifier
                    .size(64.dp)
                    .clip(CircleShape)
                    .background(MaterialTheme.colorScheme.primary),
                contentAlignment = Alignment.Center
            ) {
                val initials = "${firstName.firstOrNull() ?: ""}${lastName.firstOrNull() ?: ""}"
                    .uppercase()
                Text(
                    text = initials,
                    style = MaterialTheme.typography.headlineSmall,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onPrimary
                )
            }

            Spacer(modifier = Modifier.height(12.dp))

            Text(
                text = "$firstName $lastName",
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.SemiBold,
                color = MaterialTheme.colorScheme.onPrimaryContainer
            )

            Spacer(modifier = Modifier.height(4.dp))

            SuggestionChip(
                onClick = {},
                label = {
                    Text(
                        text = userRole,
                        style = MaterialTheme.typography.labelMedium
                    )
                }
            )
        }

        Spacer(modifier = Modifier.height(8.dp))

        // Leaderboard
        NavigationDrawerItem(
            icon = { Icon(Icons.Default.Leaderboard, contentDescription = "Leaderboard") },
            label = { Text("Leaderboard") },
            selected = false,
            onClick = onLeaderboardClick,
            modifier = Modifier.padding(horizontal = 12.dp)
        )

        // Settings
        NavigationDrawerItem(
            icon = { Icon(Icons.Default.Settings, contentDescription = "Settings") },
            label = { Text("Settings") },
            selected = false,
            onClick = onSettingsClick,
            modifier = Modifier.padding(horizontal = 12.dp)
        )

        Spacer(modifier = Modifier.weight(1f))

        HorizontalDivider(modifier = Modifier.padding(horizontal = 16.dp))

        // Logout
        NavigationDrawerItem(
            icon = {
                Icon(
                    Icons.AutoMirrored.Filled.Logout,
                    contentDescription = "Logout",
                    tint = MaterialTheme.colorScheme.error
                )
            },
            label = {
                Text(
                    "Logout",
                    color = MaterialTheme.colorScheme.error
                )
            },
            selected = false,
            onClick = onLogoutClick,
            modifier = Modifier.padding(horizontal = 12.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))
    }
}
