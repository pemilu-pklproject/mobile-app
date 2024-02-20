package com.metromatika.sipemilu.presentation.login.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.metromatika.sipemilu.R
import com.metromatika.sipemilu.presentation.main.MainViewModel
import com.metromatika.sipemilu.presentation.main.component.Screen

@Composable
fun LoginButton(
    onClick: () -> Unit
) {
    Button(
        onClick = onClick,
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = colorResource(id = R.color.orange),
            contentColor = Color.White
        ),
    ) {
        Text("Login")
    }
}

@Composable
fun ButtonRow(navController: NavHostController, viewModel: MainViewModel) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        VolunteerButton(navController, viewModel)
        Spacer(modifier = Modifier.width(16.dp))
        WitnessButton(navController, viewModel)
    }
}

@Composable
fun VolunteerButton(navController: NavHostController, viewModel: MainViewModel) {
    Button(
        onClick = {
            viewModel.setSelectedRole("Relawan")
            navController.navigate(Screen.Volunteer.route)
        },
        modifier = Modifier
            .padding(end = 4.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = colorResource(id = R.color.orange),
            contentColor = Color.White
        )
    ) {
        Text("Volunteer")
    }
}

@Composable
fun WitnessButton(navController: NavHostController, viewModel: MainViewModel) {
    Button(
        onClick = {
            viewModel.setSelectedRole("Saksi")
            navController.navigate(Screen.Witness.route)
        },
        modifier = Modifier
            .padding(start = 4.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = colorResource(id = R.color.orange),
            contentColor = Color.White
        )
    ) {
        Text("Witness")
    }
}

@Composable
fun VolunteerWitnessButton(navController: NavHostController, viewModel: MainViewModel) {
    Button(
        onClick = {
            viewModel.setSelectedRole("Saksi_Relawan")
            navController.navigate(Screen.VolunteerWitness.route)
        },
        modifier = Modifier
            .padding(start = 4.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = colorResource(id = R.color.orange),
            contentColor = Color.White
        )
    ) {
        Text("Volunteer/Witness")
    }
}