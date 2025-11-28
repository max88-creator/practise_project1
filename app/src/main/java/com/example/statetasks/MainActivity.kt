package com.example.statetasks

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Create
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.navigation.compose.rememberNavController
import com.example.statetasks.navigation_manager.AppBar
import com.example.statetasks.navigation_manager.DrawerBody
import com.example.statetasks.navigation_manager.DrawerHeader
import com.example.statetasks.navigation_manager.MenuItem
import com.example.statetasks.navigation_manager.NavManager
import com.example.statetasks.ui.theme.StateTasksTheme
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            StateTasksTheme {
                // 1. Создаем все необходимые "состояния" один раз
                val drawerState = rememberDrawerState(initialValue = DrawerValue.Open)
                val scope = rememberCoroutineScope()
                val navController = rememberNavController()

                // 2. Определяем список пунктов меню
                val menuItems = listOf(
                    MenuItem(
                        id = "first",
                        title = "First Screen",
                        contentDescription = "Go to first screen",
                        icon = Icons.Default.Home
                    ),
                    MenuItem(
                        id = "second",
                        title = "Second Screen",
                        contentDescription = "Go to second screen",
                        icon = Icons.Default.Person
                    ),
                    MenuItem(
                        id = "third",
                        title = "Third Screen",
                        contentDescription = "Go to third screen",
                        icon = Icons.Default.Create
                    )
                )

                // 3. Строим основной каркас
                ModalNavigationDrawer(
                    drawerState = drawerState,
                    drawerContent = {
                        ModalDrawerSheet { // "Лист бумаги" для меню
                            DrawerHeader()
                            DrawerBody(
                                items = menuItems,
                                onItemClick = { menuItem ->
                                    navController.navigate(menuItem.id)
                                    scope.launch {
                                        drawerState.close()
                                    }
                                }
                            )
                        }
                    }
                ) {
                    // 4. Основной экран приложения
                    Scaffold(
                        topBar = {
                            AppBar(
                                onNavigationIconClick = {
                                    scope.launch {
                                        drawerState.open()
                                    }
                                }
                            )
                        }
                    ) { innerPadding ->
                        // 5. Внутри Scaffold размещаем наш навигатор
                        NavManager(navController, innerPadding)
                    }
                }
            }
        }
    }
}
