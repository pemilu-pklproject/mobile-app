package com.metromatika.sipemilu.presentation.main.component

sealed class Screen(val route: String) {
    object Login : Screen("login_screen")
    object Volunteer : Screen("Volunteer_screen")
    object Witness : Screen("Witness_screen")
    object ProfileVolunteer : Screen("profile_volunteer_screen")
    object ProfileWitness : Screen("profile_witness_screen")
    object AddVolunteer : Screen("add_volunteer_screen")
    object AddWitness : Screen("add_witness_screen")
    object VolunteerWitness : Screen("volunteer_witness_screen")    // jumlah suara (relawan), role : saksi_relawan
    object WitnessVolunteer : Screen("witness_volunteer_screen")    // Data DPT (saksi), role : saksi_relawan
    object ProfileVolunteerWitness : Screen("profile_volunteer_witness_screen") /// profil, role: saksi_relawan
    object AddVolunteerWitness : Screen("add_volunteer_witness_screen") // unggah jumlah suara (relawan), role: saksi_relawan
    object AddWitnessVolunteer : Screen("add_witness_volunteer_screen") // tambah data dpt, role: saksi_relawan
}
