package com.example.jetpackcomposelearning.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun PlayerDetailScreen(playerName: String) {
    // Find the player in our data source based on the name passed
    val player = allPlayers.find { it.name == playerName }

    // Use a Box to allow for background coloring or imaging later
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        contentAlignment = Alignment.TopCenter
    ) {
        if (player != null) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                // Player Image
                Image(
                    painter = painterResource(id = player.imageRes),
                    contentDescription = player.name,
                    modifier = Modifier
                        .size(150.dp)
                        .clip(CircleShape) // Makes the image circular
                )

                // Player Name and Club
                Text(text = player.name, fontSize = 28.sp, fontWeight = FontWeight.Bold)
                Text(text = player.club, fontSize = 18.sp)

                Spacer(modifier = Modifier.height(16.dp))

                // Stats Row
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    StatCard("Goals", player.goals.toString())
                    StatCard("Assists", player.assists.toString())
                    StatCard("Age", player.age.toString())
                }
            }
        } else {
            Text(text = "Player not found.")
        }
    }
}

// A reusable composable for displaying a single stat
@Composable
fun StatCard(label: String, value: String) {
    Card {
        Column(
            modifier = Modifier.padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = value, fontSize = 20.sp, fontWeight = FontWeight.Bold)
            Text(text = label)
        }
    }
}