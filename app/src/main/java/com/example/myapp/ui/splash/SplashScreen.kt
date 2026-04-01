package com.example.myapp.ui.splash

import androidx.compose.animation.core.*
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.myapp.R
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(
    userName: String?,
    onSplashFinished: () -> Unit
) {
    // Navigate after 1.2 seconds
    LaunchedEffect(Unit) {
        delay(1200L)
        onSplashFinished()
    }

    // Book animation: scale up + gentle rocking
    val infiniteTransition = rememberInfiniteTransition(label = "book")

    val scale by animateFloatAsState(
        targetValue = 1f,
        animationSpec = tween(durationMillis = 800, easing = EaseOutBack),
        label = "scale"
    )

    val rotation by infiniteTransition.animateFloat(
        initialValue = -5f,
        targetValue = 5f,
        animationSpec = infiniteRepeatable(
            animation = tween(600, easing = EaseInOutSine),
            repeatMode = RepeatMode.Reverse
        ),
        label = "rotation"
    )

    // Fade in text
    val textAlpha by animateFloatAsState(
        targetValue = 1f,
        animationSpec = tween(durationMillis = 600, delayMillis = 300),
        label = "textAlpha"
    )

    // Trigger animations from 0
    var started by remember { mutableStateOf(false) }
    LaunchedEffect(Unit) { started = true }

    val animatedScale = if (started) scale else 0f
    val animatedTextAlpha = if (started) textAlpha else 0f

    val greetingText = if (userName != null) {
        "Namaste, $userName"
    } else {
        "Welcome"
    }

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Animated book icon
            Image(
                painter = painterResource(id = R.drawable.ic_book),
                contentDescription = "Book",
                colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.primary),
                modifier = Modifier
                    .size(120.dp)
                    .graphicsLayer {
                        scaleX = animatedScale
                        scaleY = animatedScale
                    }
                    .rotate(rotation)
            )

            Spacer(modifier = Modifier.height(24.dp))

            // Greeting text
            Text(
                text = greetingText,
                style = MaterialTheme.typography.headlineLarge,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.onBackground,
                modifier = Modifier.graphicsLayer { alpha = animatedTextAlpha }
            )
        }
    }
}
