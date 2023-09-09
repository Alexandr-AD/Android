package com.practicum.a30days

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.practicum.a30days.data.Day
import com.practicum.a30days.data.days
import com.practicum.a30days.ui.theme._30daysTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            _30daysTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ThirtyDaysApp()
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ThirtyDaysApp() {
    Scaffold(
        topBar = {
            ThirtyDaysAppTopBar()
        }
    ) { it ->
        LazyColumn(contentPadding = it) {
            items(days) {
                ExerciseCard(
                    day = it,
                    modifier = Modifier.padding(dimensionResource(id = R.dimen.padding_small))
                )
            }
        }

    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ExerciseCard(
    day: Day,
    modifier: Modifier = Modifier
) {
    var expanded by remember { mutableStateOf(false) }
//    val color by animateColorAsState(
//        targetValue = if (expanded) MaterialTheme.colorScheme.tertiaryContainer
//        else MaterialTheme.colorScheme.primaryContainer
//    )
    val color = MaterialTheme.colorScheme.primaryContainer

    Card(
        onClick = { expanded = !expanded },
        modifier = modifier
            .fillMaxWidth()
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .animateContentSize(
                    animationSpec = spring(
                        dampingRatio = Spring.DampingRatioNoBouncy,
                        stiffness = Spring.StiffnessMedium
                    )
                )
                .background(color = color)
        ) {
            ExInfo(numDay = day.numOfDay, exTitle = day.title)
            ExIcon(exImage = day.image)
            if(expanded){
                ExDescription(description = day.description)
            }
        }
    }
}

@Composable
fun ExInfo(
    numDay: Int,
    @StringRes exTitle: Int,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(
                start = dimensionResource(R.dimen.padding_medium),
                end = dimensionResource(R.dimen.padding_medium),
                top = dimensionResource(R.dimen.padding_medium)
            )
    ) {
        Text(
            text = stringResource(R.string.day, numDay),
            style = MaterialTheme.typography.displaySmall,
        )
        Text(
            text = stringResource(exTitle),
            style = MaterialTheme.typography.displayMedium
        )
    }
}

@Composable
fun ExIcon(
    @DrawableRes exImage: Int,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
    ) {
        Image(
            modifier = modifier
//                .size(dimensionResource(R.dimen.image_size))
                .padding(dimensionResource(R.dimen.padding_medium))
                .clip(MaterialTheme.shapes.medium)
                .fillMaxWidth(),
            painter = painterResource(exImage),
            contentDescription = null
        )
    }
}

@Composable
fun ExDescription(
    @StringRes description: Int,
    modifier: Modifier = Modifier
) {
    Text(
        modifier = modifier.padding(dimensionResource(R.dimen.padding_medium)),
        text = stringResource(description),
        style = MaterialTheme.typography.bodyLarge,
        textAlign = TextAlign.Justify
        )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ThirtyDaysAppTopBar(modifier: Modifier = Modifier) {
    CenterAlignedTopAppBar(
        title = {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = stringResource(id = R.string.app_name),
                    style = MaterialTheme.typography.displayLarge
                )
            }
        },
        modifier = modifier
    )
}


@Preview(showBackground = true)
@Composable
fun ThirtyDaysPreview() {
    _30daysTheme(darkTheme = false) {
        ThirtyDaysApp()
    }
}

@Preview(showBackground = true)
@Composable
fun ThirtyDaysDarkThemePreview() {
    _30daysTheme(darkTheme = true) {
        ThirtyDaysApp()
    }
}