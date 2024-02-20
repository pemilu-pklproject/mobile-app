package com.metromatika.sipemilu.presentation.main

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.remember
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.metromatika.sipemilu.presentation.login.LoginScreen
import com.metromatika.sipemilu.presentation.main.component.Screen
import com.metromatika.sipemilu.presentation.profile.VolunteerProfile
import com.metromatika.sipemilu.presentation.profile.VolunteerWitnessProfile
import com.metromatika.sipemilu.presentation.profile.WitnessProfile
import com.metromatika.sipemilu.presentation.profile.component.volunteerData
import com.metromatika.sipemilu.presentation.volunteer.AddVolunteer
import com.metromatika.sipemilu.presentation.volunteer.VolunteerScreen
import com.metromatika.sipemilu.presentation.volunteer_witness.AddVolunteerWitness
import com.metromatika.sipemilu.presentation.volunteer_witness.AddWitnessVolunteer
import com.metromatika.sipemilu.presentation.volunteer_witness.VolunteerWitness
import com.metromatika.sipemilu.presentation.volunteer_witness.WitnessVolunteer
import com.metromatika.sipemilu.presentation.witness.AddWitness
import com.metromatika.sipemilu.presentation.witness.WitnessScreen

@Composable
fun SetupNavGraph(
    navController: NavHostController,
) {
    val userRole = hiltViewModel<MainViewModel>().selectedRole.value
    val startDestination = remember(userRole) {
        startDestinationForRole(userRole)
    }

    NavHost(
        navController = navController,
        startDestination = startDestination
    ) {
        composable(route = Screen.Login.route) {
            LoginScreen(navController = navController)
        }
        composable(route = Screen.Witness.route) {
            WitnessScreen(navController = navController)
        }
        composable(route = Screen.Volunteer.route) {
            VolunteerScreen(navController = navController)
        }
        composable(route = Screen.ProfileVolunteer.route) {
            VolunteerProfile(navController = navController, volunteerData)
        }
        composable(route = Screen.ProfileWitness.route) {
            WitnessProfile(navController = navController, volunteerData)
        }
        composable(route = Screen.AddVolunteer.route) {
            AddVolunteer(navController = navController)
        }
        composable(route = Screen.AddWitness.route) {
            AddWitness(navController = navController)
        }
        composable(route = Screen.VolunteerWitness.route) {
            VolunteerWitness(navController = navController)
        }
        composable(route = Screen.WitnessVolunteer.route) {
            WitnessVolunteer(navController = navController)
        }
        composable(route = Screen.ProfileVolunteerWitness.route) {
            VolunteerWitnessProfile(navController = navController, volunteerData)
        }
        composable(route = Screen.AddVolunteerWitness.route) {
            AddVolunteerWitness(navController = navController)
        }
        composable(route = Screen.AddWitnessVolunteer.route) {
            AddWitnessVolunteer(navController = navController)
        }
    }

    DisposableEffect(navController) {
        onDispose {
            Log.d("NavControllerDebug", "NavGraph set: ${navController.graph}")
        }
    }
}

private fun startDestinationForRole(userRole: String?): String {
    return when (userRole) {
        "Saksi" -> Screen.Witness.route
        "Relawan" -> Screen.Volunteer.route
        "Saksi_Relawan" -> Screen.VolunteerWitness.route
        else -> Screen.Login.route
    }
}
