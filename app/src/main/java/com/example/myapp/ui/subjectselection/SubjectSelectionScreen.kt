package com.example.myapp.ui.subjectselection

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.myapp.data.model.Subject
import com.example.myapp.ui.theme.*

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SubjectSelectionScreen(
    viewModel: SubjectSelectionViewModel,
    classId: Int,
    section: String,
    onBack: () -> Unit,
    onSubjectSelected: (String) -> Unit
) {
    val subjects by viewModel.subjects.collectAsState()
    val title = if (section == "it") "IT & Technology" else "Class $classId"

    Scaffold(
        topBar = {
            TopAppBar(
                navigationIcon = {
                    IconButton(onClick = onBack) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back", tint = Color.White)
                    }
                },
                title = {
                    Column {
                        Text(
                            text = title,
                            style = MaterialTheme.typography.titleLarge,
                            fontWeight = FontWeight.Bold,
                            color = Color.White
                        )
                        Text(
                            text = "Select a subject to begin",
                            style = MaterialTheme.typography.labelMedium,
                            color = Color.White.copy(alpha = 0.7f)
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = NavBar
                )
            )
        },
        containerColor = MaterialTheme.colorScheme.background
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

private fun subjectColor(subjectId: String): Color = when (subjectId) {
    "mongodb"    -> SubjectMongoDB
    "react"      -> SubjectReact
    "python"     -> SubjectPython
    "java"       -> SubjectJava
    "docker"     -> SubjectDocker
    "kubernetes" -> SubjectKubernetes
    "maths"      -> SubjectMaths
    "physics"    -> SubjectPhysics
    "chemistry"  -> SubjectChemistry
    "geography"  -> SubjectGeography
    "history"    -> SubjectHistory
    else         -> Color(0xFF1589EE)
}

private fun subjectEmoji(subjectId: String): String = when (subjectId) {
    "mongodb"    -> "🍃"
    "react"      -> "⚛️"
    "python"     -> "🐍"
    "java"       -> "☕"
    "docker"     -> "🐳"
    "kubernetes" -> "☸️"
    "maths"      -> "📐"
    "physics"    -> "⚡"
    "chemistry"  -> "🧪"
    "geography"  -> "🌍"
    "history"    -> "📜"
    else         -> "📚"
}

@Composable
private fun SubjectCard(subject: Subject, onClick: () -> Unit) {
    val bgColor = subjectColor(subject.id)
    Card(
        onClick = onClick,
        enabled = subject.isEnabled,
        modifier = Modifier
            .fillMaxWidth()
            .height(110.dp)
            .then(if (!subject.isEnabled) Modifier.alpha(0.45f) else Modifier),
        shape = RoundedCornerShape(14.dp),
        colors = CardDefaults.cardColors(containerColor = bgColor),
        elevation = CardDefaults.cardElevation(defaultElevation = 3.dp)
    ) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = subjectEmoji(subject.id),
                    style = MaterialTheme.typography.headlineMedium
                )
                Spacer(modifier = Modifier.height(6.dp))
                Text(
                    text = subject.displayName,
                    style = MaterialTheme.typography.titleSmall,
                    fontWeight = FontWeight.Bold,
                    color = Color.White,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(horizontal = 8.dp)
                )
                if (!subject.isEnabled) {
                    Spacer(modifier = Modifier.height(3.dp))
                    Surface(
                        color = Color.Black.copy(alpha = 0.25f),
                        shape = RoundedCornerShape(4.dp)
                    ) {
                        Text(
                            text = "Coming Soon",
                            style = MaterialTheme.typography.labelSmall,
                            color = Color.White,
                            modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
                        )
                    }
                }
            }
        }
    }
}
