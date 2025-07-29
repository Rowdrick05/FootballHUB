package com.example.jetpackcomposelearning

import android.R
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun ColumnExample(modifier: Modifier = Modifier) {
//    Row(modifier = Modifier.fillMaxSize(), verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.SpaceEvenly) {
//
//        Text("Hello Rowdrick")
//        Text("Hello Rix")
//        Button(onClick = {}) {
//            Text("Click Here")
//        }

    Box(modifier = Modifier.fillMaxSize()) {
        Image(painter = painterResource(R.drawable.star_on)
            ,contentDescription = null
            , modifier = Modifier
                .width(200.dp)
                .height(120.dp).align(Alignment.Center))
        Text("Overlay Text", modifier = Modifier.align(Alignment.Center))
    }

}


@Preview(showSystemUi = true)
@Composable
fun ColumnLayoutPrev(modifier: Modifier = Modifier) {

    ColumnExample()
    
}