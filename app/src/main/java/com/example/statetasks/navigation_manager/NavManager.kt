package com.example.statetasks.navigation_manager

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.statetasks.screens.FirstScreen
import com.example.statetasks.screens.Second
import com.example.statetasks.screens.ThirdScreen

@Composable
fun NavManager(navController: NavHostController, paddingValues: PaddingValues) {

    val first = "first"
    val second = "second"
    val third = "third"

    NavHost(
        modifier = Modifier.padding(paddingValues),
        navController = navController,
        startDestination = "first"
    ) {
        composable(first) { FirstScreen(navController) }
        composable(second) { Second(navController) }
        composable(third) { ThirdScreen(navController) }
    }
}
