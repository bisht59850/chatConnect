package com.example.exp_12_s3

import android.os.Bundle
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.exp_12_s3.ui.theme.ExP_12_S3Theme
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.text.input.KeyboardType

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ExP_12_S3Theme {

                YourAppContent()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun YourAppContent() {
    var userInput by remember { mutableStateOf("0") }
    var currentValue by remember { mutableStateOf(userInput.toIntOrNull() ?: 0) }
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        OutlinedTextField(
            value = userInput,
            onValueChange = { newValue ->
                userInput = newValue
                currentValue = newValue.toIntOrNull() ?: 0
            },
            label = { Text("Enter a value") },
            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number)
        )

        Spacer(modifier = Modifier.height(16.dp))

        AnimatedCircularProgressIndicator(
            userInput = userInput,
            currentValue = currentValue,
            maxValue = 100,
            progressBackgroundColor = Color.Gray,
            progressIndicatorColor = Color.Blue,
            completedColor = Color.Green,
            modifier = Modifier.size(200.dp)
        )
    }
}

@Composable
fun AnimatedCircularProgressIndicator(
    userInput: String,
    currentValue: Int,
    maxValue: Int,
    progressBackgroundColor: Color,
    progressIndicatorColor: Color,
    completedColor: Color,
    modifier: Modifier = Modifier
) {

    val stroke = with(LocalDensity.current) {
        Stroke(width = 6.dp.toPx(), cap = StrokeCap.Round, join = StrokeJoin.Round)
    }

    Box(modifier = modifier, contentAlignment = Alignment.Center) {
        ProgressStatus(
            currentValue = currentValue,
            maxValue = maxValue,
            progressBackgroundColor = progressBackgroundColor,
            progressIndicatorColor = progressIndicatorColor,
            completedColor = completedColor
        )

        val animateFloat = remember { Animatable(0f) }



        LaunchedEffect(userInput) {
            animateFloat.animateTo(
                targetValue = currentValue / maxValue.toFloat(),
                animationSpec = tween(durationMillis = 3000, easing = FastOutSlowInEasing)
            )
        }

        Canvas(
            Modifier
                .size(CircularIndicatorDiameter)
        ) {
            val startAngle = 270f
            val sweep: Float = animateFloat.value * 360f
            val diameterOffset = stroke.width / 2

            drawCircle(
                color = progressBackgroundColor,
                style = stroke,
                radius = size.minDimension / 2.0f - diameterOffset
            )
            drawCircularProgressIndicator(startAngle, sweep, progressIndicatorColor, stroke)

            if (currentValue == maxValue) {
                drawCircle(
                    color = completedColor,
                    style = stroke,
                    radius = size.minDimension / 2.0f - diameterOffset
                )
            }
        }
    }
}

@Composable
private fun ProgressStatus(
    currentValue: Int,
    maxValue: Int,
    progressBackgroundColor: Color,
    progressIndicatorColor: Color,
    completedColor: Color,
    modifier: Modifier = Modifier
) {
    val typography = MaterialTheme.typography

    Text(
        modifier = modifier,
        text = buildAnnotatedString {
            val emphasisSpan =
                typography.headlineLarge.copy(color = if (currentValue == maxValue) completedColor else progressIndicatorColor)
                    .toSpanStyle()
            val defaultSpan =
                typography.bodyLarge.copy(color = progressBackgroundColor).toSpanStyle()
            append(AnnotatedString("$currentValue", spanStyle = emphasisSpan))
            append(AnnotatedString(text = "/", spanStyle = defaultSpan))
            append(AnnotatedString(text = "$maxValue", spanStyle = defaultSpan))
        }
    )
}

private fun DrawScope.drawCircularProgressIndicator(
    startAngle: Float,
    sweep: Float,
    color: Color,
    stroke: Stroke
) {
    val diameterOffset = stroke.width / 2
    val arcDimen = size.width - 2 * diameterOffset

    drawArc(
        color = color,
        startAngle = startAngle,
        sweepAngle = sweep,
        useCenter = false,
        topLeft = Offset(diameterOffset, diameterOffset),
        size = Size(arcDimen, arcDimen),
        style = stroke
    )
}


private val CircularIndicatorDiameter = 84.dp

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewYourAppContent() {
    ExP_12_S3Theme {
        YourAppContent()
    }
}