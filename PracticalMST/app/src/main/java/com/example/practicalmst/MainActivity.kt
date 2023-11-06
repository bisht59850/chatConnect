package com.example.practicalmst

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ATMcard()
        }
    }
}

@Composable
fun ATMcard() {
    Card(modifier = Modifier.fillMaxSize()) {
        Row(modifier=Modifier.padding(20.dp)) {
            Image(
                painter = painterResource(id = R.drawable.sbilogo1),
                contentDescription = null,
                modifier = Modifier.padding(40.dp)
            )
            Column(modifier=Modifier.padding(10.dp)) {
                Text(modifier=Modifier.padding(15.dp),text = "State bank Of India", textAlign = TextAlign.Center)
                Text(text="1234 5678 9123 4567", textAlign = TextAlign.Center)
                Text(text="D.O.B- 30/03/2001", textAlign = TextAlign.Center)
                Text(modifier = Modifier.padding(15.dp),text="Vijay Singh Bisht")
            }
            Row(horizontalArrangement = Arrangement.Center){
                Image(

                    painter= painterResource(id = R.drawable.ic_launcher_background),
                    contentDescription = null,
                    modifier = Modifier.padding(4.dp)
                )
            }
        }

    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ATMcardPreview() {
    ATMcard()
}