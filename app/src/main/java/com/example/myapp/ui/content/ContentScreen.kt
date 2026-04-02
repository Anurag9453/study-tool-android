package com.example.myapp.ui.content

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.selection.selectable
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.myapp.data.model.ContentBlock
import com.example.myapp.data.model.Question
import com.example.myapp.ui.common.AppScaffold

@Composable
fun ContentScreen(
    viewModel: ContentViewModel,
    firstName: String,
    lastName: String,
    userRole: String,
    onLogout: () -> Unit,
    onLeaderboardClick: () -> Unit
) {
    val contentBlocks by viewModel.contentBlocks.collectAsState()
    val questions by viewModel.questions.collectAsState()
    val selectedAnswers by viewModel.selectedAnswers.collectAsState()
    val isChecked by viewModel.isChecked.collectAsState()
    val isCompleted by viewModel.isCompleted.collectAsState()
    val score by viewModel.score.collectAsState()
    val attemptNumber by viewModel.attemptNumber.collectAsState()
    val pointsAwarded by viewModel.pointsAwarded.collectAsState()
    val alreadyCompleted by viewModel.alreadyCompleted.collectAsState()
    val totalPoints by viewModel.totalPoints.collectAsState()
    val allAnswered by viewModel.allAnswered.collectAsState()

    AppScaffold(
        title = "Learn",
        firstName = firstName,
        lastName = lastName,
        userRole = userRole,
        onLogout = onLogout,
        onLeaderboardClick = onLeaderboardClick
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(horizontal = 16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp),
            contentPadding = PaddingValues(vertical = 16.dp)
        ) {
            // Total points chip
            item {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.End
                ) {
                    AssistChip(
                        onClick = {},
                        label = { Text("$totalPoints pts") },
                        leadingIcon = {
                            Icon(
                                Icons.Default.Star,
                                contentDescription = null,
                                modifier = Modifier.size(18.dp)
                            )
                        }
                    )
                }
            }

            // Content blocks
            items(contentBlocks) { block ->
                when (block) {
                    is ContentBlock.TextBlock -> TextBlockItem(block)
                    is ContentBlock.ExampleBlock -> ExampleBlockItem(block)
                }
            }

            // Practice section header
            if (questions.isNotEmpty()) {
                item {
                    Spacer(modifier = Modifier.height(8.dp))
                    HorizontalDivider()
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = "Practice Questions",
                        style = MaterialTheme.typography.headlineSmall,
                        fontWeight = FontWeight.Bold
                    )
                }
            }

            // Completion banner (already completed from a previous session)
            if (alreadyCompleted && pointsAwarded != null) {
                item {
                    Card(
                        colors = CardDefaults.cardColors(
                            containerColor = MaterialTheme.colorScheme.primaryContainer
                        ),
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(16.dp),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Column {
                                Text(
                                    text = "Quiz Complete!",
                                    style = MaterialTheme.typography.titleMedium,
                                    fontWeight = FontWeight.Bold,
                                    color = MaterialTheme.colorScheme.onPrimaryContainer
                                )
                                Text(
                                    text = "Completed in $attemptNumber attempt${if (attemptNumber > 1) "s" else ""}",
                                    style = MaterialTheme.typography.bodySmall,
                                    color = MaterialTheme.colorScheme.onPrimaryContainer
                                )
                            }
                            Text(
                                text = "${pointsAwarded} pts",
                                style = MaterialTheme.typography.headlineMedium,
                                fontWeight = FontWeight.Bold,
                                color = MaterialTheme.colorScheme.primary
                            )
                        }
                    }
                }
            }

            // Just-completed banner (completed this session, not already)
            if (isCompleted && !alreadyCompleted && pointsAwarded != null) {
                item {
                    Card(
                        colors = CardDefaults.cardColors(
                            containerColor = MaterialTheme.colorScheme.primaryContainer
                        ),
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(16.dp),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Column {
                                Text(
                                    text = "All Correct!",
                                    style = MaterialTheme.typography.titleMedium,
                                    fontWeight = FontWeight.Bold,
                                    color = MaterialTheme.colorScheme.onPrimaryContainer
                                )
                                Text(
                                    text = "You earned ${pointsAwarded} points",
                                    style = MaterialTheme.typography.bodyMedium,
                                    color = MaterialTheme.colorScheme.onPrimaryContainer
                                )
                            }
                            Text(
                                text = "${pointsAwarded} pts",
                                style = MaterialTheme.typography.headlineMedium,
                                fontWeight = FontWeight.Bold,
                                color = MaterialTheme.colorScheme.primary
                            )
                        }
                    }
                }
            }

            // Retry banner (checked but not all correct)
            if (isChecked && !isCompleted) {
                item {
                    Card(
                        colors = CardDefaults.cardColors(
                            containerColor = MaterialTheme.colorScheme.errorContainer
                        ),
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Column(modifier = Modifier.padding(16.dp)) {
                            Text(
                                text = "Score: ${score}/${questions.size}",
                                style = MaterialTheme.typography.titleMedium,
                                fontWeight = FontWeight.Bold,
                                color = MaterialTheme.colorScheme.onErrorContainer
                            )
                            Text(
                                text = "Some answers are wrong. Fix them and try again!",
                                style = MaterialTheme.typography.bodyMedium,
                                color = MaterialTheme.colorScheme.onErrorContainer
                            )
                        }
                    }
                }
            }

            // Questions
            itemsIndexed(questions) { index, question ->
                QuestionItem(
                    questionNumber = index + 1,
                    question = question,
                    selectedOptionId = selectedAnswers[question.id],
                    isChecked = isChecked,
                    isCompleted = isCompleted,
                    onOptionSelected = { optionId ->
                        viewModel.onOptionSelected(question.id, optionId)
                    }
                )
            }

            // Buttons
            if (questions.isNotEmpty() && !isCompleted) {
                item {
                    Spacer(modifier = Modifier.height(8.dp))

                    if (!isChecked) {
                        // Check Answers button
                        Button(
                            onClick = { viewModel.onSubmit() },
                            enabled = allAnswered,
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Text(
                                if (attemptNumber == 1) "Check Answers"
                                else "Check Answers (Attempt $attemptNumber)"
                            )
                        }
                    } else {
                        // Retry button
                        OutlinedButton(
                            onClick = { viewModel.onRetry() },
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Text("Fix Answers & Retry")
                        }
                    }

                    Spacer(modifier = Modifier.height(16.dp))
                }
            }
        }
    }
}

@Composable
private fun TextBlockItem(block: ContentBlock.TextBlock) {
    Text(
        text = block.text,
        style = MaterialTheme.typography.bodyLarge
    )
}

@Composable
private fun ExampleBlockItem(block: ContentBlock.ExampleBlock) {
    Card(
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.secondaryContainer
        ),
        modifier = Modifier.fillMaxWidth()
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = block.heading,
                style = MaterialTheme.typography.titleSmall,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.onSecondaryContainer
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = block.body,
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSecondaryContainer
            )
        }
    }
}

@Composable
private fun QuestionItem(
    questionNumber: Int,
    question: Question,
    selectedOptionId: String?,
    isChecked: Boolean,
    isCompleted: Boolean,
    onOptionSelected: (String) -> Unit
) {
    Card(
        modifier = Modifier.fillMaxWidth()
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = "Q$questionNumber. ${question.questionText}",
                style = MaterialTheme.typography.titleSmall,
                fontWeight = FontWeight.SemiBold
            )
            Spacer(modifier = Modifier.height(12.dp))

            question.options.forEach { option ->
                val isSelected = selectedOptionId == option.id
                val isCorrect = option.id == question.correctOptionId

                val borderColor = when {
                    !isChecked && isSelected -> MaterialTheme.colorScheme.primary
                    isChecked && isCorrect -> MaterialTheme.colorScheme.primary
                    isChecked && isSelected && !isCorrect -> MaterialTheme.colorScheme.error
                    else -> MaterialTheme.colorScheme.outlineVariant
                }

                val containerColor = when {
                    isChecked && isCorrect -> MaterialTheme.colorScheme.primaryContainer.copy(alpha = 0.3f)
                    isChecked && isSelected && !isCorrect -> MaterialTheme.colorScheme.errorContainer.copy(alpha = 0.3f)
                    else -> MaterialTheme.colorScheme.surface
                }

                val canSelect = !isChecked && !isCompleted

                OutlinedCard(
                    border = BorderStroke(
                        width = if (isSelected || (isChecked && isCorrect)) 2.dp else 1.dp,
                        color = borderColor
                    ),
                    colors = CardDefaults.outlinedCardColors(containerColor = containerColor),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 3.dp)
                        .selectable(
                            selected = isSelected,
                            onClick = { if (canSelect) onOptionSelected(option.id) }
                        )
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(12.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        RadioButton(
                            selected = isSelected,
                            onClick = { if (canSelect) onOptionSelected(option.id) }
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(
                            text = option.text,
                            style = MaterialTheme.typography.bodyMedium
                        )
                    }
                }
            }

            // Explanation after check
            if (isChecked) {
                Spacer(modifier = Modifier.height(8.dp))
                Card(
                    colors = CardDefaults.cardColors(
                        containerColor = MaterialTheme.colorScheme.surfaceVariant
                    )
                ) {
                    Text(
                        text = question.explanation,
                        style = MaterialTheme.typography.bodySmall,
                        modifier = Modifier.padding(12.dp)
                    )
                }
            }
        }
    }
}
