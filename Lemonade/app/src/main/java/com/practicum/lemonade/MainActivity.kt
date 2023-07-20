package com.practicum.lemonade

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.practicum.lemonade.ui.theme.LemonadeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LemonadeTheme {
                Lemonade()
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun Lemonade() {
    Row(
        Modifier
            .background(Color(0xFFF9E44C))
            .fillMaxWidth()
            .height(100.dp),
        verticalAlignment = Alignment.Bottom,
        horizontalArrangement = Arrangement.Center
    ) {
        Text(
            modifier = Modifier.padding(16.dp),
            text = stringResource(R.string.app_name),
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold
        )
    }
    LemonTree(modifier = Modifier
        .fillMaxSize()
        .wrapContentSize(Alignment.Center)
    )
}

@Composable
fun LemonTree(modifier: Modifier = Modifier) {
    var counter by remember { mutableStateOf(0) }
    var squeezeCounter = 0
//    val imageResource = R.drawable.lemon_tree
    val imageResource = when(counter) {
        0 -> R.drawable.lemon_tree
        1 -> R.drawable.lemon_squeeze
        2 -> R.drawable.lemon_drink
        else -> R.drawable.lemon_restart
    }
    val instructions: String = when(counter) {
        0 -> stringResource(R.string.tap_lemon_tree)
        1 -> stringResource(R.string.squeeze_lemon)
        2 -> stringResource(R.string.drink_lemonade)
        else -> stringResource(R.string.start_again)
    }
    val imgDescription = when(counter) {
        0 -> stringResource(R.string.lemon_tree)
        1 -> stringResource(R.string.lemon)
        2 -> stringResource(R.string.glass_of_lemonade)
        else -> stringResource(R.string.empty_glass)
    }

    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        val randSqueeze = (2..4).random()
        Button( //0xFFC3ECD2
            shape = RoundedCornerShape(40.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFC3ECD2)),
//            modifier = Modifier.background(Color(0xFFC3ECD2)),
            onClick = {
                if(counter != 1) {
                    counter++

                    if (counter == 4) {
                        counter = 0
                    }
                } else {
                    squeezeCounter++
                    if(squeezeCounter == randSqueeze)
                    {
                        counter++
                        squeezeCounter = 0
                    }

                }
                      }
        ) {
            Image(
                painter = painterResource(imageResource),
                contentDescription = imgDescription
            )
        }
        Spacer(modifier = Modifier.height(32.dp))
        Text(
            text = instructions,
            fontSize = 18.sp,
            modifier = Modifier.padding(start = 20.dp, end = 20.dp),
            textAlign = TextAlign.Center
            )
    }
}

