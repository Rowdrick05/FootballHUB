package com.example.jetpackcomposelearning.screens

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun SearchBar(
        query: String,
        onQueryChanged: (String) -> Unit,
        onSearchClicked: () -> Unit
    )
{
        TextField(
            value = query,
            onValueChange = onQueryChanged,
            label = { Text("Search for a player...") },
                    colors = TextFieldDefaults.colors
                    (
                            focusedTextColor = Color.White,
            focusedContainerColor = Color.Black,
            focusedIndicatorColor = Color.Black,
            focusedLabelColor = Color.Black,

            // Set colors for when the field is not focused
            unfocusedTextColor = Color.LightGray,
            unfocusedContainerColor = Color.Gray,
            unfocusedIndicatorColor = Color.LightGray,
            unfocusedLabelColor = Color.LightGray
        ),
            trailingIcon = {
                IconButton(onClick = { onSearchClicked() }) {
                    Icon(
                        imageVector = Icons.Filled.Search,
                        contentDescription = "Search Icon"
                    )
                }
            }
            )
}

@Preview
@Composable
fun SearchBarPreview() {
    SearchBar(query = "Cristiano Ronaldo", onQueryChanged = {},onSearchClicked = {})
}
