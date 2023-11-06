package com.example.exp_14_s3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.exp_14_s3.ui.theme.ExP_14_S3Theme

enum class WeightStatus(val value: String, val color: Color) {
    UNDERWEIGHT("Underweight", Color.Red),
    HEALTHY_WEIGHT("Healthy Weight", Color.Blue),
    OVERWEIGHT("Overweight", Color.Red),
    OBESITY("Obesity", Color.Red)
}

fun getWeightStatus(bmiValue: Double): WeightStatus {
    return when (bmiValue) {
        in 0.0..18.4 -> WeightStatus.UNDERWEIGHT
        in 18.5..24.9 -> WeightStatus.HEALTHY_WEIGHT
        in 25.0..29.9 -> WeightStatus.OVERWEIGHT
        else -> WeightStatus.OBESITY
    }
}

fun getFormattedBMI(bmiValue: Double): String {
    return "%.1f".format(bmiValue)
}

fun calculateBMI(weight: Double, height: Double): Double {
    if (weight == 0.0 || height == 0.0) return 0.0
    return weight / (height / 100 * height / 100)
}

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ExP_14_S3Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MainContent()
                }
            }
        }
    }
}

@Composable
fun MainContent() {
    var showBmiResult by remember {
        mutableStateOf(false)
    }

    var bmiResult by remember {
        mutableStateOf(0.0)
    }

    val density = LocalDensity.current.density // Access density here

    Surface(modifier = Modifier.padding(12.dp)) {
        Column {
            BMICalculatorForm(
                onCalculateClicked = { weight, height ->
                    bmiResult = calculateBMI(weight, height)
                    showBmiResult = true
                },
                onResetClicked = {
                    bmiResult = 0.0
                    showBmiResult = false
                },
                density = density // Pass density as a parameter
            )

            Spacer(modifier = Modifier.height(20.dp))

            BMIResultForm(showBmiResult, bmiResult, density = density) // Pass density here as well
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class, ExperimentalComposeUiApi::class)
@Composable
fun BMICalculatorForm(
    onCalculateClicked: (Double, Double) -> Unit,
    onResetClicked: () -> Unit,
    density: Float
) {
    var height by remember {
        mutableStateOf("")
    }

    var weight by remember {
        mutableStateOf("")
    }

    val validHeight = height.isNotEmpty()
    val validWeight = weight.isNotEmpty()

    val keyboardController = LocalSoftwareKeyboardController.current
//    val isSoftwareKeyboardVisible = keyboardController?.isSystemKeyboardVisible ?: false

//    val imeAction = if (isSoftwareKeyboardVisible) ImeAction.Done else ImeAction.Next

    Surface(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(8.dp),
        border = BorderStroke(1.dp, color = Color.LightGray)
    ) {
        Column(
            modifier = Modifier.padding(12.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Adult BMI Calculator",
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.onPrimary,
                style = MaterialTheme.typography.labelMedium
            )

            Spacer(modifier = Modifier.height(20.dp))

            OutlinedTextField(
                value = height,
                onValueChange = { newHeight ->
                    height = newHeight
                },
                label = {
                    Text(text = "Height in cms")
                },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Number,
                    imeAction = ImeAction.Next
                ),
                keyboardActions = KeyboardActions(
                    onDone = {
                        if (validHeight && validWeight) {
                            onCalculateClicked(weight.toDouble(), height.toDouble())
                        }
                        keyboardController?.hide()
                    }
                ),
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(10.dp))

            OutlinedTextField(
                value = weight,
                onValueChange = { newWeight ->
                    weight = newWeight
                },
                label = {
                    Text(text = "Weight in kgs")
                },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Number,
                    imeAction = ImeAction.Done
                ),
                keyboardActions = KeyboardActions(
                    onDone = {
                        if (validHeight && validWeight) {
                            onCalculateClicked(weight.toDouble(), height.toDouble())
                        }
                        keyboardController?.hide()
                    }
                ),
                modifier = Modifier.fillMaxWidth()
            )

            Row(
                modifier = Modifier.fillMaxWidth().padding(12.dp),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                Button(
                    onClick = {
                        if (validHeight && validWeight) {
                            onCalculateClicked(weight.toDouble(), height.toDouble())
                        }
                    },
                    enabled = validHeight && validWeight
                ) {
                    Text(text = "Calculate")
                }

                Button(
                    onClick = {
                        weight = ""
                        height = ""
                        onResetClicked()
                    }
                ) {
                    Text(text = "Reset")
                }
            }
        }
    }
}

@Composable
fun BMIResultForm(
    showBmi: Boolean = true,
    bmiValue: Double = 0.0,
    density: Float // Pass density as a parameter
) {
    Surface(
        modifier = Modifier.fillMaxWidth().height(260.dp),
        shape = RoundedCornerShape(8.dp),
        border = BorderStroke(1.dp, color = Color.LightGray)
    ) {
        Column(
            modifier = Modifier.padding(12.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            if (showBmi) {
                val weightStatus = getWeightStatus(bmiValue)
                val bmiToDisplay = getFormattedBMI(bmiValue)
                Text(
                    text = "BMI: $bmiToDisplay",
                    fontWeight = FontWeight.ExtraBold,
                    color = weightStatus.color,
                    style = TextStyle(fontSize = 20.sp)
                )
                Spacer(modifier = Modifier.height(20.dp))
                Text(
                    text = "Weight Status: ${weightStatus.value}",
                    fontWeight = FontWeight.Bold,
                    color = weightStatus.color,
                    style = TextStyle(fontSize = 20.sp)
                )
            } else {
                Image(
                    painter = painterResource(id = R.drawable.bmi),
                    contentDescription = "BMI image",
                    modifier = Modifier.size((240 * density).dp)
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MainContentPreview() {
    ExP_14_S3Theme {
        MainContent()
    }
}