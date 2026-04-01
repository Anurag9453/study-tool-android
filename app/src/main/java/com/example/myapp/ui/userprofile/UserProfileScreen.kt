package com.example.myapp.ui.userprofile

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.myapp.data.model.UserRole

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UserProfileScreen(
    viewModel: UserProfileViewModel,
    onProfileSaved: () -> Unit
) {
    LaunchedEffect(Unit) {
        viewModel.navigationEvent.collect { onProfileSaved() }
    }

    val firstName by viewModel.firstName.collectAsState()
    val lastName by viewModel.lastName.collectAsState()
    val selectedRole by viewModel.selectedRole.collectAsState()
    val hasAttemptedSubmit by viewModel.hasAttemptedSubmit.collectAsState()

    Scaffold(
        topBar = {
            TopAppBar(title = { Text("Your Profile") })
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(horizontal = 24.dp)
                .verticalScroll(rememberScrollState()),
        ) {
            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "Tell us about yourself",
                style = MaterialTheme.typography.headlineSmall,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(24.dp))

            // First Name
            OutlinedTextField(
                value = firstName,
                onValueChange = viewModel::onFirstNameChanged,
                label = { Text("First Name *") },
                singleLine = true,
                isError = hasAttemptedSubmit && firstName.isBlank(),
                supportingText = if (hasAttemptedSubmit && firstName.isBlank()) {
                    { Text("First name is required") }
                } else null,
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(16.dp))

            // Last Name
            OutlinedTextField(
                value = lastName,
                onValueChange = viewModel::onLastNameChanged,
                label = { Text("Last Name *") },
                singleLine = true,
                isError = hasAttemptedSubmit && lastName.isBlank(),
                supportingText = if (hasAttemptedSubmit && lastName.isBlank()) {
                    { Text("Last name is required") }
                } else null,
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(24.dp))

            // Role selection
            Text(
                text = "Are you a? *",
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Medium
            )
            if (hasAttemptedSubmit && selectedRole == null) {
                Text(
                    text = "Please select a role",
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.error
                )
            }
            Spacer(modifier = Modifier.height(12.dp))

            Row(
                horizontalArrangement = Arrangement.spacedBy(12.dp),
                modifier = Modifier.fillMaxWidth()
            ) {
                UserRole.entries.forEach { role ->
                    RoleChip(
                        role = role,
                        isSelected = selectedRole == role,
                        onClick = { viewModel.onRoleSelected(role) },
                        modifier = Modifier.weight(1f)
                    )
                }
            }

            Spacer(modifier = Modifier.height(40.dp))

            // Save button
            Button(
                onClick = viewModel::onSave,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(52.dp)
            ) {
                Text(
                    text = "Save & Continue",
                    style = MaterialTheme.typography.titleMedium
                )
            }

            Spacer(modifier = Modifier.height(24.dp))
        }
    }
}

@Composable
private fun RoleChip(
    role: UserRole,
    isSelected: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    if (isSelected) {
        FilledTonalButton(
            onClick = onClick,
            modifier = modifier.height(48.dp)
        ) {
            Text(role.displayName)
        }
    } else {
        OutlinedButton(
            onClick = onClick,
            modifier = modifier.height(48.dp)
        ) {
            Text(role.displayName)
        }
    }
}
