package com.example.nav

import android.net.wifi.hotspot2.pps.HomeSp
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavHostController) {
    val modifier = Modifier
    Box(
        modifier = Modifier.fillMaxSize()
    ){
        Image(painter = painterResource(id = R.drawable.cuimsbackground),
                contentDescription = null,
                modifier = Modifier.fillMaxSize()
            )
    Column(
        modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        var nameValue by remember {
            mutableStateOf("")
        }
        var ageValue by remember {
            mutableStateOf("")
        }
        Image(painter = painterResource(id = R.drawable.cuimslogo), contentDescription = null)
        Text(text = "Log in", fontSize = 54.sp, color = Color.White)
        Text(text = "Welcome to University Learning\n" +
                "Management System", fontSize = 14.sp, color = Color.White, textAlign = TextAlign.Center)
        Spacer(modifier.height(65.dp))
        TextField(
            value = nameValue,
            onValueChange = { nameValue = it }, modifier.padding(10.dp),
            placeholder = {
                Text(text = "enter your UID")
            }
        )
        TextField(
            value = ageValue,
            onValueChange = { ageValue = it }, modifier.padding(40.dp),
            placeholder = {
                Text(text = "Enter Book Code")
            }
        )
        Button(onClick = {
            navController.navigate("Details?name=$nameValue&age=$ageValue")
        }, modifier = Modifier.padding(8.dp)) {
            Text(text = "Enter", fontSize = 30.sp)
        }

    }
}
}
