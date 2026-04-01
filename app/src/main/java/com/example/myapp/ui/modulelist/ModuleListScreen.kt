package com.example.myapp.ui.modulelist

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.myapp.data.model.Module
import com.example.myapp.ui.common.AppScaffold

@Composable
fun ModuleListScreen(
    viewModel: ModuleListViewModel,
    firstName: String,
    lastName: String,
    userRole: String,
    onLogout: () -> Unit,
    onModuleSelected: (String) -> Unit
) {
    val modules by viewModel.modules.collectAsState()

    AppScaffold(
        title = "Modules",
        firstName = firstName,
        lastName = lastName,
        userRole = userRole,
        onLogout = onLogout
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(horizontal = 16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp),
            contentPadding = PaddingValues(vertical = 8.dp)
        ) {
            items(modules) { module ->
                ModuleCard(
                    module = module,
                    onClick = { onModuleSelected(module.id) }
                )
            }
        }
    }
}

@Composable
private fun ModuleCard(module: Module, onClick: () -> Unit) {
    OutlinedCard(
        onClick = onClick,
        modifier = Modifier.fillMaxWidth()
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "${module.displayOrder}.",
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.primary
            )
            Spacer(modifier = Modifier.width(12.dp))
            Text(
                text = module.title,
                style = MaterialTheme.typography.bodyLarge,
                fontWeight = FontWeight.Medium
            )
        }
    }
}
