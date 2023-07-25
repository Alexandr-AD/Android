package com.practicum.artspace

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.practicum.artspace.ui.theme.ArtSpaceTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArtSpaceTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ArtSpaceApp()
                }
            }
        }
    }
}

@Composable
fun ArtSpaceApp() {

    Column {
        ArtWall()
    }
}

@Composable
fun ArtWall() {
    var clickCounter by remember { mutableStateOf(0) }

    val albumImage = when(clickCounter) {
        0 -> painterResource(R.drawable.night_visions)
        1 -> painterResource(R.drawable.smoke_mirrors)
        2 -> painterResource(R.drawable.evolve)
        3 -> painterResource(R.drawable.origins)
        4 -> painterResource(R.drawable.mercury1)
        else -> painterResource(R.drawable.mercury2)
    }

    val albumName = when(clickCounter) {
        0 -> stringResource(R.string.night_visions)
        1 -> stringResource(R.string.smoke_mirrors)
        2 -> stringResource(R.string.evolve)
        3 -> stringResource(R.string.origins)
        4 -> stringResource(R.string.mercury_1)
        else -> stringResource(R.string.mercury_2)
    }

    val albumYear = when(clickCounter) {
        0 -> stringResource(R.string.year_2012)
        1 -> stringResource(R.string.year_2015)
        2 -> stringResource(R.string.year_2017)
        3 -> stringResource(R.string.year_2018)
        4 -> stringResource(R.string.year_2021)
        else -> stringResource(R.string.year_2022)
    }
    Column(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.Start
    ) {
        Card(
            modifier = Modifier
                .fillMaxSize()
                .padding(4.dp)
                .weight(5f),
            shape = RectangleShape,
            colors = CardDefaults.cardColors(Color.White),
            elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
        ) {
            Column(
                modifier = Modifier
                    .fillMaxHeight(),
                verticalArrangement = Arrangement.Center
            ) {
                Image(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(20.dp),
                    painter = albumImage,
                    contentDescription = null
                )
            }
        }
        Spacer(modifier = Modifier.height(32.dp))
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(color = Color(0xFFECEBF4))
                .padding(start = 20.dp, bottom = 16.dp, top = 16.dp, end = 20.dp)
                .weight(1f),
            verticalArrangement = Arrangement.Center,
        ) {
            Text(
                text = albumName,
                fontSize = 24.sp,
                textAlign = TextAlign.Start
            )
            Text(
                text = stringResource(R.string.imag_dragons) + " " + albumYear,
                fontSize = 16.sp,
                textAlign = TextAlign.Start
            )
        }
        Row(
            modifier = Modifier
                .fillMaxHeight()
                .weight(1f),
            verticalAlignment = Alignment.Bottom,
            horizontalArrangement = Arrangement.Center
        ) {
            Button(
                onClick = {
                    clickCounter--
                    if(clickCounter == -1)
                        clickCounter = 5
                },
                modifier = Modifier
                    .padding(24.dp)
                    .fillMaxWidth()
                    .weight(1f)
            ) {
                Text("Previous")
            }
            Button(
                onClick = {
                    clickCounter++
                    if(clickCounter == 6)
                        clickCounter = 0
                          },
                modifier = Modifier
                    .padding(24.dp)
                    .fillMaxWidth()
                    .weight(1f),
            ) {
                Text("Next")
            }
        }
    }

}

@Preview(showBackground = true)
@Composable
fun ArtSpacePrev() {
    ArtSpaceTheme {
        ArtSpaceApp()
    }
}