package com.example.jetpackcomposelearning.screens

import androidx.annotation.DrawableRes
import com.example.jetpackcomposelearning.R

data class Player(
    val name: String,
    val age: Int,
    val club: String,
    val goals: Int,
    val assists: Int,
    @DrawableRes val imageRes: Int
)

val allPlayers = listOf(
    Player("Lionel Messi", 37, "Inter Miami", 837, 373, R.drawable.messiworldcup),
    Player("Cristiano Ronaldo", 39, "Al Nassr", 895, 251, R.drawable.ronaldoucl),
    Player("Neymar Jr.", 32, "Al Hilal", 439, 248,R.drawable.neymarucl),
    Player("Kylian Mbappé", 25, "Real Madrid", 330, 151,R.drawable.mbappeworldcup),
    Player("Erling Haaland", 24, "Manchester City", 259, 52,R.drawable.haalanducl)
)