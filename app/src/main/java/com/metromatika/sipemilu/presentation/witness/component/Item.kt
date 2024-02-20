package com.metromatika.sipemilu.presentation.witness.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun WitnessItem(witnessData: WitnessData) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Text("Nomor TPS: ${witnessData.noTps}")
        Spacer(modifier = Modifier.height(8.dp))
        Text("Desa/Kelurahan: ${witnessData.desaKelurahan}")
        Spacer(modifier = Modifier.height(8.dp))
        Text("Alamat: ${witnessData.alamat}")
        Spacer(modifier = Modifier.height(8.dp))
        Text("RT/RW: ${witnessData.rtRw}")
        Spacer(modifier = Modifier.height(8.dp))
        Text("Kab/Kota: ${witnessData.kabKota}")
        Spacer(modifier = Modifier.height(8.dp))
        Text("Provinsi: ${witnessData.provinsi}")
        Spacer(modifier = Modifier.height(8.dp))
        Text("Ketua KPPS: ${witnessData.ketuaKpps}")
        Spacer(modifier = Modifier.height(8.dp))
        Text("Jumlah Suara: ${witnessData.jumlahSuara}")
    }
}
