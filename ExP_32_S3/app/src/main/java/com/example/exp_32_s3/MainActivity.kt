package com.example.exp_32_s3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.exp_32_s3.ui.theme.ExP_32_S3Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ScaffoldExp()
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScaffoldExp() {
    var count by remember { mutableStateOf(0) }
    Scaffold(
        topBar = {
            TopAppBar(
                colors =
                TopAppBarDefaults.smallTopAppBarColors(containerColor =
                Color.Black ),
                title = {
                    Text(text="Top app bar",color = Color.Green)

                }
            )
        },
        bottomBar = {
            BottomAppBar(
                containerColor = Color.DarkGray
            ) {
                Text(
                    modifier = Modifier
                        .fillMaxWidth(),
                    text = "Bottom app bar",
                    color = Color.Green,
                    fontSize = 24.sp
                )
            }
        },
        floatingActionButton = {
            FloatingActionButton(onClick = { count++ }) {
                Icon(
                    Icons.Default.Add, contentDescription =
                "Add")
            }
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding),
            verticalArrangement = Arrangement.spacedBy(16.dp),
        ) {
            Text(
                modifier = Modifier.padding(8.dp),
                fontWeight = FontWeight.Bold,
                text = "$count",
            )
        }
    }}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ExP_32_S3Theme {
        ScaffoldExp()
    }
}