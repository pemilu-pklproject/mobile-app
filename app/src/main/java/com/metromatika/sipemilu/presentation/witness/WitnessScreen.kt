package com.metromatika.sipemilu.presentation.witness

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.metromatika.sipemilu.R
import com.metromatika.sipemilu.presentation.main.component.Screen
import com.metromatika.sipemilu.presentation.profile.component.witness.WitnessBottomBar
import com.metromatika.sipemilu.presentation.witness.component.WitnessItem

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WitnessScreen(
    navController: NavHostController,
    viewModel: WitnessViewModel = hiltViewModel()
) {
    val witnessList = viewModel.witnessList

    Scaffold(
        floatingActionButton = {
            FloatingActionButton(
                onClick = { navController.navigate(Screen.AddWitness.route) },
                containerColor = colorResource(id = R.color.orange),
                contentColor = Color.White
            ) {
                Icon(imageVector = Icons.Default.Add, contentDescription = "Add")
            }
        },
        bottomBar = {
            WitnessBottomBar(navController = navController)
        }
    ) {
        LazyColumn {
            items(witnessList) { witnessData ->
                WitnessItem(witnessData = witnessData)
                Divider(modifier = Modifier.padding(horizontal = 16.dp))
            }
        }
    }
}
