package com.example.myapp.ui.subjectselection

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
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.myapp.data.model.Subject

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SubjectSelectionScreen(
    viewModel: SubjectSelectionViewModel,
    classId: Int,
    section: String,
    onSubjectSelected: (String) -> Unit
) {
    val subjects by viewModel.subjects.collectAsState()
    val title = if (section == "it") "IT & Technology" else "Class $classId — Select Subject"

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(title) }
            )
        }
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
            items(subjects) { subject ->
                SubjectCard(
                    subject = subject,
                    onClick = {
                        if (subject.isEnabled) onSubjectSelected(subject.id)
                    }
                )
            }
        }
    }
}

@Composable
private fun SubjectCard(subject: Subject, onClick: () -> Unit) {
    ElevatedCard(
        onClick = onClick,
        enabled = subject.isEnabled,
        modifier = Modifier
            .fillMaxWidth()
            .height(100.dp)
            .then(if (!subject.isEnabled) Modifier.alpha(0.45f) else Modifier)
    ) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text(
                    text = subject.displayName,
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.SemiBold,
                    textAlign = TextAlign.Center
                )
                if (!subject.isEnabled) {
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                        text = "Coming Soon",
                        style = MaterialTheme.typography.labelSmall,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
            }
        }
    }
}
