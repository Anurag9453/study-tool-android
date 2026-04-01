package com.example.myapp.ui.classselection

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.myapp.data.model.SchoolClass
import com.example.myapp.ui.common.AppScaffold

@Composable
fun ClassSelectionScreen(
    viewModel: ClassSelectionViewModel,
    firstName: String,
    lastName: String,
    userRole: String,
    onLogout: () -> Unit,
    onClassSelected: (Int) -> Unit
) {
    val classes by viewModel.classes.collectAsState()

    AppScaffold(
        title = "Select Your Class",
        firstName = firstName,
        lastName = lastName,
        userRole = userRole,
        onLogout = onLogout
    ) { innerPadding ->
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(16.dp),
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(classes) { schoolClass ->
                ClassCard(
                    schoolClass = schoolClass,
                    onClick = {
                        viewModel.onClassSelected(schoolClass.id)
                        onClassSelected(schoolClass.id)
                    }
                )
            }
        }
    }
}

@Composable
private fun ClassCard(schoolClass: SchoolClass, onClick: () -> Unit) {
    ElevatedCard(
        onClick = onClick,
        modifier = Modifier
            .fillMaxWidth()
            .height(100.dp)
    ) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = schoolClass.displayName,
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.SemiBold,
                textAlign = TextAlign.Center
            )
        }
    }
}
