package com.example.jetpackcomposelearning.screens
import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.jetpackcomposelearning.R
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController


@SuppressLint("InvalidColorHexValue")
@Composable
fun WelcomeScreen(navController: NavController, modifier: Modifier = Modifier) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(R.color.black))
    )
    {

        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    brush = Brush.verticalGradient(
                        colors = listOf(
                            Color(0xFF00FDFD),
                            Color(color = 0xFF15E837),
                            Color(color = 0xFF098A03)
                        )
                    )
                ), contentAlignment = Alignment.Center
        )

        {
            Box(
                modifier = Modifier
                    .size(950.dp)
                    )
            {
                Image(
                    painter = painterResource(R.drawable.imgfootballhub),
                    contentDescription = null,
                    Modifier.fillMaxSize().alpha(0.9f)
                )
            }

            Button(onClick = {
                navController.navigate("main_screen")
            },
                modifier = Modifier.align(Alignment.BottomCenter)
                    .padding(50.dp)
                    .fillMaxWidth()
                    .size(50.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF27D5CC),
                        contentColor = Color.Black)
            )
             {
                Text("Click to continue  ---->")
            }
        }


    }


}


@Preview(showSystemUi = true)
@Composable
fun PrevEx(modifier: Modifier = Modifier) {
    WelcomeScreen(navController = rememberNavController())
}