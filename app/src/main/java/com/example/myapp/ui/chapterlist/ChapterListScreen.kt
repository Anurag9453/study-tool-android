package com.example.myapp.ui.chapterlist

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.QuestionAnswer
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.myapp.data.model.Chapter

private fun subjectDisplayName(subjectId: String) = when (subjectId) {
    "maths"      -> "Mathematics"
    "physics"    -> "Physics"
    "chemistry"  -> "Chemistry"
    "geography"  -> "Geography"
    "history"    -> "History"
    "react"      -> "React"
    "python"     -> "Python"
    "java"       -> "Java"
    "mongodb"    -> "MongoDB"
    "docker"     -> "Docker"
    "kubernetes" -> "Kubernetes"
    else         -> subjectId
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ChapterListScreen(
    viewModel: ChapterListViewModel,
    subjectId: String,
    onChapterSelected: (String) -> Unit,
    onQAClicked: (String) -> Unit
) {
    val chapters by viewModel.chapters.collectAsState()
    val subjectName = subjectDisplayName(subjectId)

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Chapters") },
                actions = {
                    IconButton(onClick = { onQAClicked(subjectName) }) {
                        Icon(
                            imageVector = Icons.Default.QuestionAnswer,
                            contentDescription = "Q&A"
                        )
                    }
                }
            )
        }
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(horizontal = 16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp),
            contentPadding = PaddingValues(vertical = 8.dp)
        ) {
            items(chapters) { chapter ->
                ChapterCard(
                    chapter = chapter,
                    onClick = { onChapterSelected(chapter.id) }
                )
            }
        }
    }
}

@Composable
private fun ChapterCard(chapter: Chapter, onClick: () -> Unit) {
    ElevatedCard(
        onClick = onClick,
        modifier = Modifier.fillMaxWidth()
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Surface(
                shape = MaterialTheme.shapes.small,
                color = MaterialTheme.colorScheme.primaryContainer,
                modifier = Modifier.size(40.dp)
            ) {
                Box(contentAlignment = Alignment.Center) {
                    Text(
                        text = "${chapter.displayOrder}",
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.onPrimaryContainer
                    )
                }
            }
            Spacer(modifier = Modifier.width(16.dp))
            Text(
                text = chapter.title,
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Medium
            )
        }
    }
}
