package com.metromatika.sipemilu.presentation.volunteer_witness

import android.annotation.SuppressLint
import android.net.Uri
import android.view.ViewTreeObserver
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.metromatika.sipemilu.R
import com.metromatika.sipemilu.presentation.witness.WitnessViewModel
import com.metromatika.sipemilu.presentation.witness.component.WitnessData

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddWitnessVolunteer(
    navController: NavHostController,
) {
    val viewModel: WitnessViewModel = viewModel()

    var noTps by remember { mutableStateOf("") }
    var desaKelurahan by remember { mutableStateOf("") }
    var alamat by remember { mutableStateOf("") }
    var rtRw by remember { mutableStateOf("") }
    var kabKota by remember { mutableStateOf("") }
    var provinsi by remember { mutableStateOf("") }
    var ketuaKpps by remember { mutableStateOf("") }
    var jumlahSuara by remember { mutableStateOf("") }

//    var isUploading by remember { mutableStateOf(false) }
//    var uploadedFileName by remember { mutableStateOf("") }
//    val coroutineScope = rememberCoroutineScope()

    var selectedImageUri by remember { mutableStateOf<Uri?>(null) }

    val photoPickerLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent(),
        onResult = { uri: Uri? -> selectedImageUri = uri }
    )

    val imeState = rememberImeState()
    val scrollState = rememberScrollState()

    LaunchedEffect(key1 = imeState.value) {
        if (imeState.value) {
            scrollState.animateScrollTo(scrollState.maxValue, tween(300))
        }
    }

    val softwareKeyboardController = LocalSoftwareKeyboardController.current

    val uploadSuccessMessage = if (selectedImageUri != null) {
        "Upload Gambar Berhasil!"
    } else {
        "Upload Foto C6"
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Data TPS") },
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
                .padding(16.dp, 120.dp, 16.dp, 16.dp),
            contentAlignment = Alignment.Center
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .verticalScroll(scrollState),
            ) {
                OutlinedTextField(
                    modifier = Modifier
                        .fillMaxWidth(),
                    value = noTps,
                    onValueChange = { noTps = it },
                ) { Text("Nomor") }

                Spacer(modifier = Modifier.height(16.dp))

                OutlinedTextField(
                    modifier = Modifier
                        .fillMaxWidth(),
                    value = desaKelurahan,
                    onValueChange = { desaKelurahan = it },
                ) { Text("Desa/Kelurahan") }

                Spacer(modifier = Modifier.height(16.dp))

                OutlinedTextField(
                    modifier = Modifier.fillMaxWidth(),
                    value = alamat,
                    onValueChange = { alamat = it },
                ) { Text("Alamat") }

                Spacer(modifier = Modifier.height(16.dp))

                OutlinedTextField(
                    modifier = Modifier.fillMaxWidth(),
                    value = rtRw,
                    onValueChange = { rtRw = it },
                ) { Text("RT/RW") }

                Spacer(modifier = Modifier.height(16.dp))

                OutlinedTextField(
                    modifier = Modifier.fillMaxWidth(),
                    value = kabKota,
                    onValueChange = { kabKota = it },
                ) { Text("Kab/Kota") }

                Spacer(modifier = Modifier.height(16.dp))

                OutlinedTextField(
                    modifier = Modifier.fillMaxWidth(),
                    value = provinsi,
                    onValueChange = { provinsi = it },
                ) { Text("Provinsi") }

                Spacer(modifier = Modifier.height(16.dp))

                OutlinedTextField(
                    modifier = Modifier
                        .fillMaxWidth()
                        .onFocusChanged { state ->
                            if (state.isFocused) {
                                softwareKeyboardController?.show()
                            }
                        },
                    value = ketuaKpps,
                    onValueChange = { ketuaKpps = it },
                ) { Text("Ketua KPPS") }

                Spacer(modifier = Modifier.height(16.dp))

                OutlinedTextField(
                    modifier = Modifier.fillMaxWidth(),
                    value = jumlahSuara,
                    onValueChange = { jumlahSuara = it },
                ) { Text("Total Jumlah Suara (isi dalam angka)") }

                Spacer(modifier = Modifier.height(32.dp))

                Button(
                    onClick = {
                        if (selectedImageUri == null) {
                            photoPickerLauncher.launch("image/*")
                        }
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = if (selectedImageUri != null) {
                            colorResource(id = R.color.white)
                        } else {
                            colorResource(id = R.color.orange)
                        },
                        contentColor = Color.Black
                    )
                ) {
                    Text(text = uploadSuccessMessage)
                }

                Button(
                    onClick = {
                        viewModel.addWitness(
                            WitnessData(
                                noTps = noTps,
                                desaKelurahan = desaKelurahan,
                                alamat = alamat,
                                rtRw = rtRw,
                                kabKota = kabKota,
                                provinsi = provinsi,
                                ketuaKpps = ketuaKpps,
                                jumlahSuara = jumlahSuara
                            )
                        )
//                        isUploading = true
//
//                        coroutineScope.launch {
//                            delay(2000)
//
//                            isUploading = false
//                            uploadedFileName = "example_file.txt"
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = colorResource(id = R.color.orange),
                        contentColor = Color.White
                    )
                ) {
                    Text("Kirim")
//                    Row(
//                        verticalAlignment = Alignment.CenterVertically,
//                        horizontalArrangement = Arrangement.Center
//                    ) {
//                        if (isUploading) {
//                            LinearProgressIndicator(
//                                modifier = Modifier
//                                    .height(2.dp)
//                                    .weight(1f),
//                                color = Color.Gray
//                            )
//                            Spacer(modifier = Modifier.width(8.dp))
//                            Text(text = "Uploading: $uploadedFileName")
//                        } else {
//                            Text("Kirim")
//                        }
//                    }
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun OutlinedTextField(
    modifier: Modifier = Modifier,
    value: String,
    onValueChange: (String) -> Unit,
    placeholder: @Composable () -> Unit
) {
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        modifier = modifier,
        label = {
            placeholder()
        }
    )
}

@Composable
fun rememberImeState(): State<Boolean> {
    val imeState = remember {
        mutableStateOf(false)
    }

    val view = LocalView.current
    DisposableEffect(view) {
        val listener = ViewTreeObserver.OnGlobalLayoutListener {
            val isKeyboardOpen = ViewCompat.getRootWindowInsets(view)
                ?.isVisible(WindowInsetsCompat.Type.ime()) ?: true
            imeState.value = isKeyboardOpen
        }

        view.viewTreeObserver.addOnGlobalLayoutListener(listener)
        onDispose {
            view.viewTreeObserver.removeOnGlobalLayoutListener(listener)
        }
    }
    return imeState
}
