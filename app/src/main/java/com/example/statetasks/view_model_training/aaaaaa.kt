package com.example.statetasks.view_model_training

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun UserName(
    userViewModel: UserViewModel
) {
    var input by remember { mutableStateOf("") }
    val newName by userViewModel.userName.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TextField(
            value = input,
            onValueChange = { input = it }
        )
        Spacer(Modifier.height(25.dp))
        Text(
            text = newName
        )
        Spacer(Modifier.height(25.dp))
        Button(
            onClick = {
                userViewModel.upName(input)
            }
        ) {
            Text(
                text = "Update"
            )
        }
    }
}