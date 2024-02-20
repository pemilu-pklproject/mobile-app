package com.metromatika.sipemilu.presentation.profile.component

data class VolunteerData(
    val name: String,
    val email: String,
    val nik: String,
    val phone: String,
)

val volunteerData = VolunteerData(
    name = "Metromatika Teknologi Rekayasa",
    email = "metromatika@gmail.com",
    nik = "1234xxxx",
    phone = "081234567"
)