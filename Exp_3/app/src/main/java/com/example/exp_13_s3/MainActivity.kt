package com.example.exp_13_s3

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.tooling.preview.Preview
import com.example.exp_13_s3.ui.theme.Exp_13_S3Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Exp_13_S3Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    LongPressDoubleTapImageApp()
                }
            }
        }
    }
}

@Composable
fun LongPressDoubleTapImageApp() {
    var isImage1Visible by remember { mutableStateOf(true) }
    var doubleTapDetected1 by remember { mutableStateOf(false) }

    var isImage2Visible by remember { mutableStateOf(true) }
    var doubleTapDetected2 by remember { mutableStateOf(false) }

    var isImage3Visible by remember { mutableStateOf(true) }
    var doubleTapDetected3 by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        // Image 1
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .background(Color.LightGray)
                .pointerInput(Unit) {
                    detectTapGestures { offset ->
                        doubleTapDetected1 = true
                    }
                }
                .graphicsLayer {
                    if (!isImage1Visible) {
                        alpha = 0f
                    }
                }
        ) {
            if (isImage1Visible) {
                Image(
                    painter = painterResource(id = R.drawable.p4),
                    contentDescription = null,
                    modifier = Modifier.fillMaxSize()
                )
            }
        }

        // Image 2
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .background(Color.LightGray)
                .pointerInput(Unit) {
                    detectTapGestures { offset ->
                        doubleTapDetected2 = true
                    }
                }
                .graphicsLayer {
                    if (!isImage2Visible) {
                        alpha = 0f
                    }
                }
        ) {
            if (isImage2Visible) {
                Image(
                    painter = painterResource(id = R.drawable.p4),
                    contentDescription = null,
                    modifier = Modifier.fillMaxSize()
                )
            }
        }

        // Image 3
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .background(Color.LightGray)
                .pointerInput(Unit) {
                    detectTapGestures { offset ->
                        doubleTapDetected3 = true
                    }
                }
                .graphicsLayer {
                    if (!isImage3Visible) {
                        alpha = 0f
                    }
                }
        ) {
            if (isImage3Visible) {
                Image(
                    painter = painterResource(id = R.drawable.p4),
                    contentDescription = null,
                    modifier = Modifier.fillMaxSize()
                )
            }
        }
    }

    // Detect double-tap gestures and control image visibility
    if (doubleTapDetected1) {
        doubleTapDetected1 = false
        isImage1Visible = !isImage1Visible
    } else if (doubleTapDetected2) {
        doubleTapDetected2 = false
        isImage2Visible = !isImage2Visible
    } else if (doubleTapDetected3) {
        doubleTapDetected3 = false
        isImage3Visible = !isImage3Visible
    }
}

@Preview
@Composable
fun LongPressDoubleTapImageAppPreview() {
    LongPressDoubleTapImageApp()
}
