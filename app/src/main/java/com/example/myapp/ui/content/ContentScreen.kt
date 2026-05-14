package com.example.myapp.ui.content

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.ContentCopy
import androidx.compose.material.icons.filled.EmojiEvents
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalClipboardManager
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapp.data.model.ContentBlock
import com.example.myapp.data.model.Question
import com.example.myapp.ui.theme.NavBar

private val CodeBackground = Color(0xFF1E293B)   // dark slate
private val CodeText = Color(0xFFE2E8F0)          // light gray
private val InlineCodeText = Color(0xFFFF6B6B)    // coral red
private val InlineCodeBg = Color(0xFFF1F5F9)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ContentScreen(viewModel: ContentViewModel, onBack: () -> Unit) {
    val contentBlocks by viewModel.contentBlocks.collectAsState()
    val questions by viewModel.questions.collectAsState()
    val selectedAnswers by viewModel.selectedAnswers.collectAsState()
    val isSubmitted by viewModel.isSubmitted.collectAsState()
    val score by viewModel.score.collectAsState()
    val isLoading by viewModel.isLoading.collectAsState()

    Scaffold(
        topBar = {
            TopAppBar(
                navigationIcon = {
                    IconButton(onClick = onBack) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back", tint = Color.White)
                    }
                },
                title = {
                    Text(
                        text = viewModel.moduleTitle.ifBlank { "Learn" },
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                        color = Color.White,
                        fontWeight = FontWeight.SemiBold
                    )
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = NavBar
                )
            )
        },
        containerColor = MaterialTheme.colorScheme.background
    ) { innerPadding ->
        if (isLoading) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding),
                contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator(color = MaterialTheme.colorScheme.primary)
            }
        } else {
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding)
                    .padding(horizontal = 16.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp),
                contentPadding = PaddingValues(vertical = 16.dp)
            ) {
                items(contentBlocks) { block ->
                    when (block) {
                        is ContentBlock.TextBlock -> TextBlockItem(block)
                        is ContentBlock.ExampleBlock -> ExampleBlockItem(block)
                    }
                }

                if (questions.isNotEmpty()) {
                    item {
                        Spacer(modifier = Modifier.height(4.dp))
                        // Trailhead-style "Check Your Knowledge" banner
                        Card(
                            shape = RoundedCornerShape(12.dp),
                            colors = CardDefaults.cardColors(containerColor = NavBar),
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Row(
                                modifier = Modifier.padding(horizontal = 16.dp, vertical = 14.dp),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Icon(
                                    imageVector = Icons.Default.EmojiEvents,
                                    contentDescription = null,
                                    tint = Color(0xFFF5A623),
                                    modifier = Modifier.size(22.dp)
                                )
                                Spacer(modifier = Modifier.width(10.dp))
                                Column {
                                    Text(
                                        text = "Check Your Knowledge",
                                        style = MaterialTheme.typography.titleMedium,
                                        fontWeight = FontWeight.Bold,
                                        color = Color.White
                                    )
                                    Text(
                                        text = "${questions.size} questions",
                                        style = MaterialTheme.typography.labelSmall,
                                        color = Color.White.copy(alpha = 0.7f)
                                    )
                                }
                            }
                        }
                    }
                }

                if (score != null) {
                    item {
                        val s = score!!
                        val (scoreEmoji, scoreMessage, scoreColor) = when {
                            s == questions.size ->
                                Triple("🏆", "Perfect score! Zabardast!", Color(0xFF3BA755))
                            s * 3 >= questions.size * 2 ->
                                Triple("🎖️", "Bahut badhiya! Almost there!", Color(0xFF1589EE))
                            s > 0 ->
                                Triple("💪", "Accha kiya! Thoda aur practice karo.", Color(0xFFE45E1B))
                            else ->
                                Triple("📖", "Practice karo — agli baar zaroor!", Color(0xFF9050E9))
                        }
                        Card(
                            shape = RoundedCornerShape(12.dp),
                            colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
                            elevation = CardDefaults.cardElevation(2.dp),
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(IntrinsicSize.Min)
                            ) {
                                Box(
                                    modifier = Modifier
                                        .width(5.dp)
                                        .fillMaxHeight()
                                        .background(
                                            scoreColor,
                                            RoundedCornerShape(topStart = 12.dp, bottomStart = 12.dp)
                                        )
                                )
                                Column(modifier = Modifier.padding(16.dp)) {
                                    Row(verticalAlignment = Alignment.CenterVertically) {
                                        Text(text = scoreEmoji, fontSize = 24.sp)
                                        Spacer(modifier = Modifier.width(10.dp))
                                        Column {
                                            Text(
                                                text = "Score: $s / ${questions.size}",
                                                style = MaterialTheme.typography.titleMedium,
                                                fontWeight = FontWeight.Bold,
                                                color = scoreColor
                                            )
                                            Text(
                                                text = scoreMessage,
                                                style = MaterialTheme.typography.bodySmall,
                                                color = MaterialTheme.colorScheme.onSurfaceVariant
                                            )
                                        }
                                    }
                                }
                            }
                        }
                    }
                }

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

                if (questions.isNotEmpty() && !isSubmitted) {
                    item {
                        Spacer(modifier = Modifier.height(8.dp))
                        Button(
                            onClick = { viewModel.onSubmit() },
                            enabled = viewModel.allAnswered,
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(52.dp),
                            shape = RoundedCornerShape(12.dp),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = MaterialTheme.colorScheme.secondary
                            )
                        ) {
                            Text(
                                text = "Submit Answers",
                                style = MaterialTheme.typography.titleMedium,
                                fontWeight = FontWeight.Bold
                            )
                        }
                        Spacer(modifier = Modifier.height(16.dp))
                    }
                }
            }
        }
    }
}

private fun inlineCode(text: String): AnnotatedString = buildAnnotatedString {
    val segments = text.split("`")
    segments.forEachIndexed { i, segment ->
        if (i % 2 == 0) {
            append(segment)
        } else {
            withStyle(
                SpanStyle(
                    color = InlineCodeText,
                    background = InlineCodeBg,
                    fontFamily = FontFamily.Monospace,
                    fontSize = 13.sp
                )
            ) {
                append(" $segment ")
            }
        }
    }
}

@Composable
private fun TextBlockItem(block: ContentBlock.TextBlock) {
    val parts = block.text.split("\n\n", limit = 2)
    if (parts.size == 2) {
        Card(
            colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
            shape = RoundedCornerShape(12.dp),
            elevation = CardDefaults.cardElevation(defaultElevation = 1.dp),
            modifier = Modifier.fillMaxWidth()
        ) {
            Column {
                // Title bar — Trailhead style dark header
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(NavBar.copy(alpha = 0.9f))
                        .padding(horizontal = 14.dp, vertical = 11.dp)
                ) {
                    Text(
                        text = inlineCode(parts[0]),
                        style = MaterialTheme.typography.titleSmall,
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                    )
                }
                Text(
                    text = inlineCode(parts[1]),
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurface,
                    modifier = Modifier.padding(horizontal = 14.dp, vertical = 12.dp)
                )
            }
        }
    } else {
        Text(
            text = inlineCode(block.text),
            style = MaterialTheme.typography.bodyLarge,
            color = MaterialTheme.colorScheme.onBackground
        )
    }
}

@Composable
private fun ExampleBlockItem(block: ContentBlock.ExampleBlock) {
    val clipboardManager = LocalClipboardManager.current
    val trimmed = block.body.trimStart()
    val isCopyable = trimmed.startsWith("//") ||
        trimmed.startsWith("db.") ||
        trimmed.startsWith("{ \"") ||
        trimmed.startsWith("{\n") ||
        trimmed.startsWith("mongodump") ||
        trimmed.startsWith("mongoexport") ||
        trimmed.startsWith("mongoimport") ||
        trimmed.startsWith("mongorestore") ||
        trimmed.startsWith("Syntax:\ndb.") ||
        trimmed.startsWith("Syntax:\nmongodump") ||
        trimmed.startsWith("Syntax:\nmongoexport") ||
        trimmed.startsWith("Syntax:\nmongoimport") ||
        trimmed.startsWith("Syntax:\nmongorestore")

    Card(
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
        modifier = Modifier.fillMaxWidth()
    ) {
        Column {
            // Heading row — orange accent like Trailhead example boxes
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(MaterialTheme.colorScheme.secondary.copy(alpha = 0.12f))
                    .padding(horizontal = 14.dp, vertical = 10.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = block.heading,
                    style = MaterialTheme.typography.labelLarge,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.secondary,
                    modifier = Modifier.weight(1f)
                )
                if (isCopyable) {
                    IconButton(
                        onClick = { clipboardManager.setText(AnnotatedString(block.body)) },
                        modifier = Modifier.size(30.dp)
                    ) {
                        Icon(
                            imageVector = Icons.Filled.ContentCopy,
                            contentDescription = "Copy code",
                            tint = MaterialTheme.colorScheme.secondary.copy(alpha = 0.8f),
                            modifier = Modifier.size(16.dp)
                        )
                    }
                }
            }
            // Dark code body — Trailhead-style syntax block
            Text(
                text = block.body,
                style = MaterialTheme.typography.bodySmall.copy(
                    fontFamily = FontFamily.Monospace,
                    lineHeight = 20.sp
                ),
                color = CodeText,
                modifier = Modifier
                    .fillMaxWidth()
                    .background(CodeBackground)
                    .padding(14.dp)
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
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
        elevation = CardDefaults.cardElevation(defaultElevation = 1.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Row(verticalAlignment = Alignment.Top) {
                Surface(
                    color = MaterialTheme.colorScheme.primary,
                    shape = RoundedCornerShape(8.dp)
                ) {
                    Text(
                        text = "Q$questionNumber",
                        style = MaterialTheme.typography.labelMedium,
                        fontWeight = FontWeight.Bold,
                        color = Color.White,
                        modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
                    )
                }
                Spacer(modifier = Modifier.width(10.dp))
                Text(
                    text = question.questionText,
                    style = MaterialTheme.typography.bodyLarge,
                    fontWeight = FontWeight.Medium,
                    modifier = Modifier.weight(1f)
                )
            }
            Spacer(modifier = Modifier.height(12.dp))

            question.options.forEach { option ->
                val isSelected = selectedOptionId == option.id
                val isCorrect = option.id == question.correctOptionId

                val borderColor = when {
                    !isSubmitted && isSelected -> MaterialTheme.colorScheme.primary
                    isSubmitted && isCorrect -> Color(0xFF3BA755)
                    isSubmitted && isSelected && !isCorrect -> MaterialTheme.colorScheme.error
                    else -> MaterialTheme.colorScheme.outlineVariant
                }
                val containerColor = when {
                    isSubmitted && isCorrect -> Color(0xFFE8F5E9)
                    isSubmitted && isSelected && !isCorrect ->
                        MaterialTheme.colorScheme.errorContainer.copy(alpha = 0.3f)
                    !isSubmitted && isSelected ->
                        MaterialTheme.colorScheme.primaryContainer.copy(alpha = 0.4f)
                    else -> MaterialTheme.colorScheme.surface
                }

                OutlinedCard(
                    border = BorderStroke(
                        width = if (isSelected || (isSubmitted && isCorrect)) 2.dp else 1.dp,
                        color = borderColor
                    ),
                    shape = RoundedCornerShape(10.dp),
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
                            .padding(horizontal = 12.dp, vertical = 10.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        RadioButton(
                            selected = isSelected,
                            onClick = { if (!isSubmitted) onOptionSelected(option.id) },
                            colors = RadioButtonDefaults.colors(
                                selectedColor = if (isSubmitted && isCorrect) Color(0xFF3BA755)
                                else MaterialTheme.colorScheme.primary
                            )
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(
                            text = option.text,
                            style = MaterialTheme.typography.bodyMedium
                        )
                    }
                }
            }

            if (isSubmitted) {
                Spacer(modifier = Modifier.height(10.dp))
                Card(
                    shape = RoundedCornerShape(10.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = MaterialTheme.colorScheme.primaryContainer.copy(alpha = 0.4f)
                    )
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(IntrinsicSize.Min)
                    ) {
                        Box(
                            modifier = Modifier
                                .width(4.dp)
                                .fillMaxHeight()
                                .background(MaterialTheme.colorScheme.primary)
                        )
                        Column(modifier = Modifier.padding(12.dp)) {
                            Text(
                                text = "💡 Explanation",
                                style = MaterialTheme.typography.labelMedium,
                                fontWeight = FontWeight.Bold,
                                color = MaterialTheme.colorScheme.primary
                            )
                            Spacer(modifier = Modifier.height(4.dp))
                            Text(
                                text = question.explanation,
                                style = MaterialTheme.typography.bodyMedium,
                                color = MaterialTheme.colorScheme.onSurface
                            )
                        }
                    }
                }
            }
        }
    }
}
