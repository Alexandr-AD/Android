package com.practicum.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Email
import androidx.compose.material.icons.rounded.Phone
import androidx.compose.material.icons.rounded.Share
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.practicum.businesscard.ui.theme.BusinessCardTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BusinessCardTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    BusinessCardApp()
                }
            }
        }
    }
}

@Composable
fun BusinessCardApp() {//name: String) { //0xFFD2E8D4
    Column(
        Modifier
            .fillMaxWidth()
            .background(
                Color(0xFFD2E8D4)
            )
    ) {
        Row(Modifier.weight(3f)) {
            AndroidLogo(stringResource(R.string.my_name),
                stringResource(R.string.my_description),
                modifier = Modifier.weight(2f))
        }
        Row(Modifier.weight(1f)) {
            ContactData(stringResource(R.string.phone_number),
                stringResource(R.string.telegram_contact),
                            stringResource(R.string.email)
                        )
        }
    }
}

@Composable
fun AndroidLogo(
    nameDev: String,
    position: String,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        val image = painterResource(R.drawable.android_logo)
        Box(
            Modifier.background(Color(0xFF073042))
        ) {
            Image(
                painter = image,
                contentDescription = "Android logo",
                modifier = Modifier
                    .height(100.dp)
                    .width(100.dp)
            )
        }
        Text(
            text = nameDev,
            fontSize = 36.sp,
            modifier = Modifier.padding(16.dp),
            textAlign = TextAlign.Justify,
            fontWeight = FontWeight.Light
        )
        Text(
            text = position,
//            modifier = Modifier.padding(16.dp),
            textAlign = TextAlign.Justify,
            fontWeight = FontWeight.Medium
        )
    }
}

@Composable
fun ContactData(
    phone: String,
    tg: String,
    email: String,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(bottom = 16.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Column(Modifier.weight(10f)) {
            Column(Modifier.weight(6f),
            verticalArrangement = Arrangement.Center)
            {
                Row(
                    Modifier.padding(bottom = 16.dp)
                ) {
                    Icon(
                        Icons.Rounded.Phone,
                        contentDescription = "my phone number",
                        modifier = Modifier.padding(end = 20.dp)
                    )
                    Text(
                        text = phone
                    )
                }
                Row(
                    Modifier.padding(bottom = 16.dp)
                ) {
                    Icon(
                        Icons.Rounded.Share,
                        contentDescription = "my phone number",
                        modifier = Modifier.padding(end = 20.dp)
                    )
                    Text(
                        text = tg
                    )
                }
                Row(
                    Modifier.padding(bottom = 16.dp)
                ) {
                    Icon(
                        Icons.Rounded.Email,
                        contentDescription = "my phone number",
                        modifier = Modifier.padding(end = 20.dp)
                    )
                    Text(
                        text = email
                    )
                }
            }
            
        }

    }
}
@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BusinessCardTheme {
        BusinessCardApp()
    }
}