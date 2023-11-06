package com.example.nav

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun DetailsScreen(myName: String?, BookCode: Int?, navController: NavController){
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Text(text = "AMAD", textAlign = TextAlign.Center, fontSize = 45.sp)
        Spacer(modifier = Modifier.height(35.dp))
        Text(text = "Your UID is: $myName", fontSize = 18.sp)
        Spacer(modifier = Modifier.height(15.dp))
        Text(text = "Book Code: $BookCode", fontSize = 18.sp)
        Spacer(modifier = Modifier.height(30.dp))
        Text(text = "Unit 1:", fontSize = 30.sp, fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.height(12.dp))
        Text(text = "Introduction: Basic of Compose, UI component with Declrative functions, Basic Layouts, Material Designs" +
                "Lists and Animation work in compose. Material design System, Styling Text, drawing in compose, animating elements," +
                " Custom layouts and graphics, Constraints and modifier order", fontSize = 22.sp)
        Spacer(modifier = Modifier.height(12.dp))
        Text(text = "Experiment No 1: Use Material APIs to configure " +
                "typography, including using downloadable fonts and variable fonts", fontSize = 22.sp)
        Spacer(modifier = Modifier.height(12.dp))
        Text(text = "Experiment No 2: Create an app that shows the use of transition", fontSize = 22.sp)
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = {
            navController.popBackStack()
        }) {
            Text(text = "Back", fontSize = 22.sp)
        }
    }
}
@Composable
@Preview(showSystemUi = true, showBackground = true)
fun Preview(){
    DetailsScreen(myName = "22MCA20017", BookCode  = 21, navController = rememberNavController() )
}

