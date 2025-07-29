package com.example.jetpackcomposelearning

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun LazyRowExample(modifier: Modifier = Modifier) {

    LazyRow {
        items(count = 10){index->

            Text("Item $index",Modifier.padding(20.dp, top = 30.dp))

        }
    }

}

@Preview(showSystemUi = true)
@Composable
fun Prev(modifier: Modifier = Modifier) {

    LazyRowExample()

}