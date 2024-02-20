package com.metromatika.sipemilu.presentation.volunteer_witness

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.LocationCity
import androidx.compose.material.icons.outlined.LocationOn
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.Phone
import androidx.compose.material.icons.outlined.SdCard
import androidx.compose.material.icons.outlined.Wc
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.metromatika.sipemilu.R
import com.metromatika.sipemilu.presentation.main.MainViewModel
import com.metromatika.sipemilu.presentation.profile.component.VolunteerData

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddVolunteerWitness(
    navController: NavHostController,
    viewModel: MainViewModel = hiltViewModel()
) {
    var name by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var gender by remember { mutableStateOf("") }
    var nik by remember { mutableStateOf("") }
    var phone by remember { mutableStateOf("") }
    var address by remember { mutableStateOf("") }
    var rtRw by remember { mutableStateOf("") }
    var kelDesa by remember { mutableStateOf("") }
    var kecamatan by remember { mutableStateOf("") }
    var kabKota by remember { mutableStateOf("") }
    var provinsi by remember { mutableStateOf("") }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Tambah Data DPT") },
                navigationIcon = {
                    IconButton(
                        onClick = {
                            navController.popBackStack()
                        }
                    ) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Back")
                    }
                },
                colors = TopAppBarDefaults.smallTopAppBarColors(
                    containerColor = colorResource(id = R.color.orange)
                )
            )
        },
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp, 100.dp, 16.dp, 16.dp),
            contentAlignment = Alignment.Center
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
                    .verticalScroll(rememberScrollState())
            ) {
                OutlinedTextFieldWithIcon(
                    modifier = Modifier.fillMaxWidth(),
                    value = name,
                    onValueChange = { name = it },
                    icon = Icons.Outlined.Person,
                    placeholder = { Text("Nama") }
                )

                Spacer(modifier = Modifier.height(16.dp))

                OutlinedTextFieldWithIcon(
                    modifier = Modifier.fillMaxWidth(),
                    value = email,
                    onValueChange = { email = it },
                    icon = Icons.Outlined.Email,
                    placeholder = { Text("Email") }
                )

                Spacer(modifier = Modifier.height(16.dp))

                // Radio button for gender
                OutlinedTextFieldWithIcon(
                    modifier = Modifier.fillMaxWidth(),
                    value = gender,
                    onValueChange = { gender = it },
                    icon = Icons.Outlined.Wc,
                    placeholder = { Text("Jenis Kelamin") },
                    isRadioButton = true
                )

                Spacer(modifier = Modifier.height(16.dp))

                OutlinedTextFieldWithIcon(
                    modifier = Modifier.fillMaxWidth(),
                    value = nik,
                    onValueChange = { nik = it },
                    icon = Icons.Outlined.SdCard,
                    placeholder = { Text("NIK") }
                )

                Spacer(modifier = Modifier.height(16.dp))

                OutlinedTextFieldWithIcon(
                    modifier = Modifier.fillMaxWidth(),
                    value = phone,
                    onValueChange = { phone = it },
                    icon = Icons.Outlined.Phone,
                    placeholder = { Text("No Hp") }
                )

                Spacer(modifier = Modifier.height(16.dp))

                // Additional address fields
                OutlinedTextFieldWithIcon(
                    modifier = Modifier.fillMaxWidth(),
                    value = address,
                    onValueChange = { address = it },
                    icon = Icons.Outlined.LocationCity,
                    placeholder = { Text("Alamat") }
                )

                Spacer(modifier = Modifier.height(16.dp))

                OutlinedTextFieldWithIcon(
                    modifier = Modifier.fillMaxWidth(),
                    value = rtRw,
                    onValueChange = { rtRw = it },
                    icon = Icons.Outlined.LocationOn,
                    placeholder = { Text("RT/RW") }
                )

                Spacer(modifier = Modifier.height(16.dp))

                OutlinedTextFieldWithIcon(
                    modifier = Modifier.fillMaxWidth(),
                    value = kelDesa,
                    onValueChange = { kelDesa = it },
                    icon = Icons.Outlined.LocationCity,
                    placeholder = { Text("Kelurahan/Desa") }
                )

                Spacer(modifier = Modifier.height(16.dp))

                OutlinedTextFieldWithIcon(
                    modifier = Modifier.fillMaxWidth(),
                    value = kecamatan,
                    onValueChange = { kecamatan = it },
                    icon = Icons.Outlined.LocationCity,
                    placeholder = { Text("Kecamatan") }
                )

                Spacer(modifier = Modifier.height(16.dp))

                OutlinedTextFieldWithIcon(
                    modifier = Modifier.fillMaxWidth(),
                    value = kabKota,
                    onValueChange = { kabKota = it },
                    icon = Icons.Outlined.LocationCity,
                    placeholder = { Text("Kabupaten/Kota") }
                )

                Spacer(modifier = Modifier.height(16.dp))

                OutlinedTextFieldWithIcon(
                    modifier = Modifier.fillMaxWidth(),
                    value = provinsi,
                    onValueChange = { provinsi = it },
                    icon = Icons.Outlined.LocationCity,
                    placeholder = { Text("Provinsi") }
                )

                Spacer(modifier = Modifier.height(32.dp))

                Button(
                    onClick = {
                        val newVolunteer = VolunteerData(
                            name = name,
                            phone = phone,
                            email = email,
                            nik = nik,
                        )
                        viewModel.saveVolunteer(newVolunteer)
                        navController.popBackStack()
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = colorResource(id = R.color.orange),
                        contentColor = Color.White
                    )
                ) {
                    Text("Simpan")
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun OutlinedTextFieldWithIcon(
    modifier: Modifier = Modifier,
    value: String,
    onValueChange: (String) -> Unit,
    icon: ImageVector,
    placeholder: @Composable () -> Unit,
    isRadioButton: Boolean = false
) {
    if (isRadioButton) {
        var selectedGender by remember { mutableStateOf("") }

        Column(modifier = Modifier.selectableGroup()) {
            Row(
                modifier = modifier
                    .fillMaxWidth()
                    .height(56.dp)
                    .selectable(
                        selected = (selectedGender == "Laki-laki"),
                        onClick = { selectedGender = "Laki-laki" },
                        role = Role.RadioButton
                    )
                    .padding(horizontal = 16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                RadioButton(
                    selected = (selectedGender == "Laki-laki"),
                    onClick = { selectedGender = "Laki-laki" },
                    modifier = Modifier.padding(end = 16.dp)
                )
                Text(text = "Laki-laki")
            }

            Row(
                modifier = modifier
                    .fillMaxWidth()
                    .height(56.dp)
                    .selectable(
                        selected = (selectedGender == "Perempuan"),
                        onClick = { selectedGender = "Perempuan" },
                        role = Role.RadioButton
                    )
                    .padding(horizontal = 16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                RadioButton(
                    selected = (selectedGender == "Perempuan"),
                    onClick = { selectedGender = "Perempuan" },
                    modifier = Modifier.padding(end = 16.dp)
                )
                Text(text = "Perempuan")
            }
        }
    } else {
        OutlinedTextField(
            value = value,
            onValueChange = onValueChange,
            modifier = modifier,
            label = { placeholder() },
            leadingIcon = {
                Icon(imageVector = icon, contentDescription = null)
            }
        )
    }
}
