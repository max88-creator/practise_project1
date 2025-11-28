package com.example.statetasks.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.statetasks.R
import com.example.statetasks.ui.theme.Typography

@Composable
fun ThirdScreen(navController: NavHostController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Image(
            modifier = Modifier.fillMaxSize(),
            painter = painterResource(
                id = R.drawable.third
            ),
            contentDescription = "third",
            contentScale = ContentScale.Crop
        )
        Column(
            modifier = Modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                "Welcome to the Third Screen",
                style = Typography.displayLarge,
                color = Color.Green
            )
            Spacer(Modifier.height(35.dp))
            Button(
                onClick = { navController.popBackStack() }
            ) { Text(
                text = "Back"
            )}
            Spacer(Modifier.height(15.dp))
            Button(
                onClick = { navController.navigate("first") }
            ) { Text(
                text = "First"
            )}
            Spacer(Modifier.height(15.dp))
            Button(
                onClick = { navController.navigate("second") }
            ) { Text(
                text = "Second"
            )}
        }
    }
}
