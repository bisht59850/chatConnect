package com.example.exp_31_s3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        setContent {
            val viewModel = remember { MainViewModel() }
            App(viewModel = viewModel)
        }
    }
}


@Composable
fun App(viewModel: MainViewModel) {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "listscreen") {
        composable(route = "listscreen") {
            PreviewItem(navController)
        }
        composable(route =  "message/{senderName}") {
            ChatScreen(
                model = ChatUiModel(
                    messages = viewModel.conversation.collectAsState().value,
                    addressee = ChatUiModel.Author.bot
                ),
                onSendChatClickListener = { msg -> viewModel.sendChat(msg) },
                modifier = Modifier,
                viewModel = viewModel
            )
        }

    }
}


@Preview(showSystemUi = true)
@Composable
fun Previewfunction(){
    val viewModel = remember { MainViewModel() } // Create an instance of MainViewModel
    App(viewModel = viewModel)
}

