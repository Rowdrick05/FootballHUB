package com.example.jetpackcomposelearning.screens


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.jetpackcomposelearning.R


@Composable
fun MainScreen(navController: NavController,
               mainViewModel: MainViewModel = viewModel()
) {
    // The state for the search query now lives in the parent screen.
    val searchQuery by mainViewModel.searchQuery.collectAsState()
    val players by mainViewModel.players.collectAsState()
    Box(modifier = Modifier.fillMaxSize())
    {
        //Image in the background
        Image(
            painter =  painterResource(id = R.drawable.imgfootballhub),
        contentDescription = null,
        modifier = Modifier
            .fillMaxSize()
            .alpha(0.9f),
        contentScale = ContentScale.Crop,
            )


        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Transparent)
                .padding(46.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Bottom// Adds space between items
        )
        {
            // Pass the state down to the SearchBar
            SearchBar(
                query = searchQuery,
                onQueryChanged = mainViewModel::onSearchQueryChanged,
                        onSearchClicked =  mainViewModel::performSearch
            )
        }
    }

            // Pass the state down to the Results
            PlayerResults(players = players, navController = navController)
}


@Preview(showSystemUi = true)
@Composable
fun MainScreenPreview() {
    MainScreen(navController = rememberNavController())
}

