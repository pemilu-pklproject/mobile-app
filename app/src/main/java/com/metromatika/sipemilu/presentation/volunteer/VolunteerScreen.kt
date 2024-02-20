package com.metromatika.sipemilu.presentation.volunteer

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.metromatika.sipemilu.R
import com.metromatika.sipemilu.presentation.main.MainViewModel
import com.metromatika.sipemilu.presentation.main.component.Screen
import com.metromatika.sipemilu.presentation.volunteer.component.VolunteerBottomBar
import com.metromatika.sipemilu.presentation.volunteer.component.SearchBar
import com.metromatika.sipemilu.presentation.volunteer.component.VolunteerCard

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun VolunteerScreen(
    navController: NavHostController,
    viewModel: MainViewModel = hiltViewModel()
) {
    val volunteerList by rememberUpdatedState(viewModel.volunteerList)

    Scaffold(
        topBar = { SearchBar() },
        floatingActionButton = {
            FloatingActionButton(
                onClick = { navController.navigate(Screen.AddVolunteer.route) },
                containerColor = colorResource(id = R.color.orange),
                contentColor = Color.White
            ) {
                Icon(imageVector = Icons.Default.Add, contentDescription = "Add")
            }
        },
        bottomBar = { VolunteerBottomBar(navController = navController) }
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White),
            contentAlignment = Alignment.Center
        ) {
            LazyColumn {
                items(volunteerList) { volunteer ->
                    VolunteerCard(volunteer = volunteer)
                }
            }
        }
    }
}
