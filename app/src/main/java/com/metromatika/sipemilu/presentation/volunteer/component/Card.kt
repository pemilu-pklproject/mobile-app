package com.metromatika.sipemilu.presentation.volunteer.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.metromatika.sipemilu.presentation.profile.component.VolunteerData

@Composable
fun VolunteerCard(volunteer: VolunteerData) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .clickable { },
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Text(text = "Nama: ${volunteer.name}")
            Text(text = "Contact: ${volunteer.phone}")
            Text(text = "Email: ${volunteer.email}")
            Text(text = "Alamat: ${volunteer.nik}")
        }
    }
}
