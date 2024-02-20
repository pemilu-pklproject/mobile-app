package com.metromatika.sipemilu.presentation.profile.component.witness

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Logout
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import com.metromatika.sipemilu.presentation.main.component.Screen

@Composable
fun LogoutButton(navController: NavHostController) {
    IconButton(
        onClick = {
            navController.navigate(Screen.Login.route) {
                popUpTo(navController.graph.findStartDestination().id) {
                    saveState = true
                }
                restoreState = true
                launchSingleTop = true
            }
        }
    ) {
        Icon(Icons.Default.Logout, contentDescription = "Log Out")
    }
}