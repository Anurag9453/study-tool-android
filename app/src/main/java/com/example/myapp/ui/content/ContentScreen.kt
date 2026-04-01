package com.example.myapp.ui.content

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.selection.selectable
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

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ContentScreen(viewModel: ContentViewModel) {
    val contentBlocks by viewModel.contentBlocks.collectAsState()
    val questions by viewModel.questions.collectAsState()
    val selectedAnswers by viewModel.selectedAnswers.collectAsState()
    val isSubmitted by viewModel.isSubmitted.collectAsState()
    val score by viewModel.score.collectAsState()

    Scaffold(
        topBar = {
            TopAppBar(title = { Text("Learn") })
        }
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(horizontal = 16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp),
            contentPadding = PaddingValues(vertical = 16.dp)
        ) {
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

            // Score card
            if (score != null) {
                item {
                    Card(
                        colors = CardDefaults.cardColors(
                            containerColor = MaterialTheme.colorScheme.tertiaryContainer
                        ),
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text(
                            text = "Score: ${score}/${questions.size}",
                            style = MaterialTheme.typography.titleLarge,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.padding(16.dp),
                            color = MaterialTheme.colorScheme.onTertiaryContainer
                        )
                    }
                }
            }

            // Questions
            itemsIndexed(questions) { index, question ->
                QuestionItem(
                    questionNumber = index + 1,
                    question = question,
                    selectedOptionId = selectedAnswers[question.id],
                    isSubmitted = isSubmitted,
                    onOptionSelected = { optionId ->
                        viewModel.onOptionSelected(question.id, optionId)
                    }
                )
            }

            // Submit button
            if (questions.isNotEmpty() && !isSubmitted) {
                item {
                    Spacer(modifier = Modifier.height(8.dp))
                    Button(
                        onClick = { viewModel.onSubmit() },
                        enabled = viewModel.allAnswered,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text("Check Answers")
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
    isSubmitted: Boolean,
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
                    !isSubmitted && isSelected -> MaterialTheme.colorScheme.primary
                    isSubmitted && isCorrect -> MaterialTheme.colorScheme.primary
                    isSubmitted && isSelected && !isCorrect -> MaterialTheme.colorScheme.error
                    else -> MaterialTheme.colorScheme.outlineVariant
                }

                val containerColor = when {
                    isSubmitted && isCorrect -> MaterialTheme.colorScheme.primaryContainer.copy(alpha = 0.3f)
                    isSubmitted && isSelected && !isCorrect -> MaterialTheme.colorScheme.errorContainer.copy(alpha = 0.3f)
                    else -> MaterialTheme.colorScheme.surface
                }

                OutlinedCard(
                    border = BorderStroke(
                        width = if (isSelected || (isSubmitted && isCorrect)) 2.dp else 1.dp,
                        color = borderColor
                    ),
                    colors = CardDefaults.outlinedCardColors(containerColor = containerColor),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 3.dp)
                        .selectable(
                            selected = isSelected,
                            onClick = { if (!isSubmitted) onOptionSelected(option.id) }
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
                            onClick = { if (!isSubmitted) onOptionSelected(option.id) }
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(
                            text = option.text,
                            style = MaterialTheme.typography.bodyMedium
                        )
                    }
                }
            }

            // Explanation after submit
            if (isSubmitted) {
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
