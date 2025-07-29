package com.example.jetpackcomposelearning.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController


@Composable
fun PlayerResults(players: List<Player>, navController: NavController) {
    LazyColumn {
        items(players) { player ->
            // 2. Pass the NavController down to each card
            PlayerCard(player = player, navController = navController)
        }
    }
}

@Composable
// 3. Update the PlayerCard to accept the NavController
fun PlayerCard(player: Player, navController: NavController) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp)
            .clickable {
                navController.navigate("player_detail/${player.name}")
            }
    ){
        // Use a Column to stack the text vertically
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(4.dp) // Adds a little space between each Text
        ) {
            // Make the player's name large and bold
            Text(
                text = player.name,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )
            // Make the club name smaller and gray
            Text(
                text = player.club,
                fontSize = 14.sp,
                color = Color.Gray
            )

            Spacer(modifier = Modifier.height(8.dp)) // Add a larger space

            // Display the rest of the stats
            Text(text = "Goals: ${player.goals}")
            Text(text = "Assists: ${player.assists}")
        }
    }
    }


@Preview
@Composable
fun PlayerResultsPreview() {
    PlayerResults(
    players = allPlayers.take(2), // Takes the first 2 players for the preview
    navController = rememberNavController()
    )
}