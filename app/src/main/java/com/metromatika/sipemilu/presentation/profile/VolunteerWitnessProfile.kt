package com.metromatika.sipemilu.presentation.profile

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.metromatika.sipemilu.R
import com.metromatika.sipemilu.presentation.profile.component.VolunteerData
import com.metromatika.sipemilu.presentation.profile.component.volunteer_witness.LogoutButton
import com.metromatika.sipemilu.presentation.profile.component.volunteer_witness.ProfileItem
import com.metromatika.sipemilu.presentation.profile.component.volunteer_witness.VolunteerWitnessProfileBottomBar

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun VolunteerWitnessProfile(
    navController: NavHostController,
    volunteerData: VolunteerData
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Profil") },
                actions = { LogoutButton(navController = navController) },
                colors = TopAppBarDefaults.smallTopAppBarColors(
                    containerColor = colorResource(id = R.color.orange)
                )
            )
        },
        bottomBar = { VolunteerWitnessProfileBottomBar(navController = navController) }
    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
                .padding(16.dp, top = 120.dp)
        ) {
            item {
                Text(
                    text = "Data Diri Anda : ",
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp,
                    modifier = Modifier.padding(bottom = 8.dp)
                )
                Divider(color = MaterialTheme.colorScheme.primary, thickness = 2.dp)
            }

            item {
                ProfileItem(label = "Nama", value = volunteerData.name)
                ProfileItem(label = "Kontak", value = volunteerData.phone)
                ProfileItem(label = "Alamat", value = volunteerData.nik)
                ProfileItem(label = "Email", value = volunteerData.email)
            }
        }
    }
}
