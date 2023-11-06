package com.example.exp_24_s3

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.exp_24_s3.ui.theme.ExP_24_S3Theme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.absolutePadding
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.ui.Alignment
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.Icon
import androidx.compose.material3.IconToggleButton
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.sp
import androidx.compose.material.icons.filled.ThumbUp
import androidx.compose.material3.Card
import androidx.compose.material.icons.filled.Star


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ExP_24_S3Theme {

                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    LargeBox()
                }
            }
        }
    }
}

@Composable
private fun LargeBox() {
    var counter by remember {
        mutableStateOf(0)
    }
    var counterr by remember {
        mutableStateOf(0)
    }
    var isFavorite by remember { mutableStateOf(false) }
    val context = LocalContext.current
    LaunchedEffect(key1 = true) {
        Toast.makeText(context, "hello", Toast.LENGTH_SHORT).show()
    }
    Column() {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.CenterHorizontally)
        ) {
            Box() {
                Image(
                    painter = painterResource(
                        id = R.drawable.cr7,
                    ), contentDescription = null, modifier = Modifier.fillMaxWidth()
                )
            }
        }
        Spacer(modifier = Modifier.padding(4.dp))
        Row()
        {
                Row() {
                    Spacer(modifier = Modifier.padding(3.dp))
                    Icon(
                        imageVector = Icons.Default.ThumbUp,
                        contentDescription = null,
                        tint = Color.Unspecified,
                        modifier = Modifier.paddingFromBaseline(20.dp)
                            .graphicsLayer {
                                scaleX = 1.3f
                                scaleY = 1.3f

                            }
                            .clickable { counter++ }

                    )
                }

            Spacer(modifier = Modifier.padding(8.dp))
            Icon(
                imageVector = Icons.Default.Star,
                contentDescription = null,
                tint = Color.Unspecified,
                modifier = Modifier.paddingFromBaseline(20.dp)
                    .graphicsLayer {
                        scaleX = 1.3f
                        scaleY = 1.3f

                    }
                    .clickable { counterr++ })
            IconToggleButton(
                checked = isFavorite,
                onCheckedChange = {
                    isFavorite = !isFavorite
                }
            ) {
                Icon(
                    tint = Color.Unspecified,
                    modifier = Modifier.paddingFromBaseline(20.dp)
                        .graphicsLayer {
                            scaleX = 1.3f
                            scaleY = 1.3f

                        },
                    imageVector = if (isFavorite) {
                        Icons.Filled.Favorite
                    } else {
                        Icons.Default.FavoriteBorder
                    },
                    contentDescription = null
                )
            }

        }
        Spacer(modifier = Modifier.padding(2.dp))
        Text(modifier = Modifier.absolutePadding(5.dp),
            text = "$counter Liked this post",
            color = Color.Red,
            fontSize = 18.sp
        )
        Spacer(modifier = Modifier.padding(2.dp))
        Text(modifier = Modifier.absolutePadding(5.dp),
            text = "$counterr favourite this post",
            color = Color.Red,
            fontSize = 18.sp
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview() {
    ExP_24_S3Theme {
        LargeBox()
    }
}