package com.practicum.superheroes

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.practicum.superheroes.model.Hero
import com.practicum.superheroes.model.HeroesRepository.heroes

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HeroApp() {
    Scaffold(
        topBar = {
            SuperheroesTopAppBar()
        }
    ) { it ->
        LazyColumn(contentPadding = it) {
            items(heroes) {
                HeroCard(
                    hero = it,
                    modifier = Modifier.padding(
                        start = dimensionResource(id = R.dimen.padding_big),
                        end = dimensionResource(id = R.dimen.padding_big),
                        top = dimensionResource(id = R.dimen.padding_small),
                        bottom = dimensionResource(id = R.dimen.padding_small)
                    )
                )
            }
        }
    }
}

@Composable
fun HeroCard(hero: Hero, modifier: Modifier = Modifier) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .clip(MaterialTheme.shapes.medium),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)

    ) {
        Row(
            modifier = Modifier
                .padding(dimensionResource(R.dimen.padding_big))
                .height(dimensionResource(R.dimen.image_size)),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(11f)
                    .padding(end = dimensionResource(id = R.dimen.padding_big)),
                horizontalAlignment = Alignment.Start
            ) {
                Text(
                    text = stringResource(hero.nameRes),
                    style = MaterialTheme.typography.displaySmall
                )
                Text(
                    text = stringResource(hero.descriptionRes),
                    style = MaterialTheme.typography.bodyLarge
                )
            }
            Box(
                modifier = Modifier
                    .weight(3f)
                    .fillMaxWidth(),
//                    .padding(start = dimensionResource(id = R.dimen.padding_big)),
            ) {
                Image(
                    modifier = Modifier
                        //                    .fillMaxHeight()
                        .size(dimensionResource(R.dimen.image_size))
//                        .padding(start = dimensionResource(R.dimen.padding_big))
                        .clip(MaterialTheme.shapes.small),
                    painter = painterResource(hero.imageRes),
                    contentDescription = null
                )
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SuperheroesTopAppBar(modifier: Modifier = Modifier) {
    CenterAlignedTopAppBar(
        title = {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
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
