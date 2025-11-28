package com.example.statetasks.navigation_manager

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.statetasks.screens.FirstScreen
import com.example.statetasks.screens.Second
import com.example.statetasks.screens.ThirdScreen

//@Composable
//fun NavManager(navController1: NavHostController, innerPadding: PaddingValues) {
//    val navController = rememberNavController()
//    NavHost(
//        navController = navController,
//        startDestination = "first"
//    ) {
//        composable("first") { FirstScreen(navController) }
//        composable("second") { Second(navController) }
//        composable("third") { ThirdScreen(navController) }
//    }
//}