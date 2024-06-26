package com.example.lemonade

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lemonade.ui.theme.LemonadeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LemonadeTheme {
                LemonadeApp()
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LemonadeApp() {
    LemonadeCard()
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LemonadeCard() {

    var currentStep by remember { mutableIntStateOf(1) }
    var clicks by remember { mutableIntStateOf(0) }

    Scaffold(topBar = {
        CenterAlignedTopAppBar(
            title = {
                Text(
                    text = "Lemonade", fontWeight = FontWeight.Bold
                )
            }, colors = TopAppBarDefaults.largeTopAppBarColors(
                containerColor = Color.Yellow
            )
        )
    }) { innerPadding ->
        Surface(
            color = MaterialTheme.colorScheme.background,
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            when (currentStep) {
                1 -> {
                    ImageTextComponent(
                        imageResource = R.drawable.lemon_tree,
                        textResource = R.string.text_01,
                        onImageClick = {
                            currentStep = 2
                            clicks = (2..4).random() // Número aleatorio para la cantidad de clicks
                        },
                        modifier = Modifier
                    )
                }

                2 -> {
                    ImageTextComponent(
                        imageResource = R.drawable.lemon_squeeze,
                        textResource = R.string.text_02,
                        onImageClick = {
                            clicks-- // Disminuye el número de clicks
                            if (clicks == 0) { // Cuando se llega a 0, pasa al siguiente paso
                                currentStep = 3
                            }
                        },
                        modifier = Modifier
                    )
                }

                3 -> {
                    ImageTextComponent(
                        imageResource = R.drawable.lemon_drink,
                        textResource = R.string.text_03,
                        onImageClick = {
                            currentStep = 4
                        },
                        modifier = Modifier
                    )
                }

                4 -> {
                    ImageTextComponent(
                        imageResource = R.drawable.lemon_restart,
                        textResource = R.string.text_04,
                        onImageClick = {
                            currentStep = 1
                        },
                        modifier = Modifier
                    )
                }
            }
        }
    }
}

@Composable
fun ImageTextComponent(
    imageResource: Int, textResource: Int, onImageClick: () -> Unit, modifier: Modifier
) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ) {
        Button(
            onClick = onImageClick,
            shape = RoundedCornerShape(40.dp),
            colors = ButtonDefaults.buttonColors(Color(130, 224, 170))
        ) {
            Image(
                painter = painterResource(id = imageResource),
                contentDescription = textResource.toString()
            )
        }
        Text(
            text = stringResource(id = textResource),
            fontSize = 18.sp,
            modifier = Modifier.padding(16.dp)
        )
    }
}
