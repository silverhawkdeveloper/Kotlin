package com.example.businesscardsapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscardsapp.ui.theme.BusinessCardsAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BusinessCardsAppTheme {}
        }
    }
}

@Composable
fun BusinessCards(
    name: String,
    skill: String,
    mobile: String,
    link: String,
    email: String,
    modifier: Modifier = Modifier
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .background(Color(171, 235, 198))//.padding(8.dp)
    ) {
        Row(
            modifier = Modifier.padding(top = 150.dp)
        ) {
            Image(
                painter = painterResource(R.drawable.android_logo),
                modifier = Modifier.size(150.dp).
                background(Color(26, 82, 118)),
                contentDescription = null
            )
        }
        Row {
            Text(
                text = name, fontSize = 50.sp, modifier = modifier

            )
        }
        Row(
            modifier = Modifier.padding(bottom = 300.dp)
        ) {
            Text(
                text = skill,
                fontWeight = FontWeight.Bold,
                color = Color(46, 204, 113),
                modifier = modifier
            )
        }
        Column(
            modifier = Modifier.padding(8.dp)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(bottom = 10.dp)
            ) {
                Column {
                    Icon(
                        painter = painterResource(R.drawable.phone_24dp),
                        contentDescription = "Email",
                        tint = Color(46, 204, 113),
                        modifier = Modifier.padding(end = 10.dp)
                    )
                }
                Column {
                    Text(
                        text = mobile, fontSize = 14.sp, modifier = modifier
                    )
                }
            }
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(bottom = 10.dp)
            ) {
                Column {
                    Icon(
                        painter = painterResource(R.drawable.share_24dp),
                        contentDescription = "Share",
                        tint = Color(46, 204, 113),
                        modifier = Modifier.padding(end = 10.dp)
                    )
                }
                Column {
                    Text(
                        text = link, fontSize = 14.sp, modifier = modifier
                    )
                }
            }
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(bottom = 10.dp)
            ) {
                Column {
                    Icon(
                        painter = painterResource(R.drawable.email_24dp),
                        contentDescription = "Email",
                        tint = Color(46, 204, 113),
                        modifier = Modifier.padding(end = 10.dp)
                    )
                }
                Column {
                    Text(
                        text = email, fontSize = 14.sp, modifier = modifier
                    )
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BusinessCardsAppTheme {
        BusinessCards(
            name = stringResource(R.string.name),
            skill = stringResource(R.string.skill),
            mobile = stringResource(R.string.mobile),
            link = stringResource(R.string.link),
            email = stringResource(R.string.email)
        )
    }
}