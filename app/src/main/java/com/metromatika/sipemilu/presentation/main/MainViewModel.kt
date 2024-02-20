package com.metromatika.sipemilu.presentation.main

import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.metromatika.sipemilu.data.local.datastore.DataStoreRepository
import com.metromatika.sipemilu.presentation.main.component.Screen
import com.metromatika.sipemilu.presentation.profile.component.VolunteerData
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repository: DataStoreRepository,
    private val connectivityManager: ConnectivityManager
) : ViewModel() {

    private val _isLoading = mutableStateOf(true)
    val isLoading: State<Boolean> = _isLoading

    private val _selectedRole = mutableStateOf("")
    val selectedRole: State<String> = _selectedRole

    init {
        viewModelScope.launch {
            // Check network connectivity
            if (isNetworkConnected()) {
                repository.readSelectedRole().collect { role ->
                    _selectedRole.value = role
                }
                _isLoading.value = false

                if (_selectedRole.value.isEmpty()) {
                    val defaultRole = determineDefaultRole()
                    _selectedRole.value = defaultRole
                    repository.saveSelectedRole(defaultRole)
                }
            } else {
                _isLoading.value = false
            }
        }
    }

    fun setSelectedRole(role: String) {
        viewModelScope.launch {
            _selectedRole.value = role
            repository.saveSelectedRole(role)
        }
    }

    private fun determineDefaultRole(): String {
        return Screen.Login.route
    }

    fun initSelectedRole() {
        viewModelScope.launch {
            repository.readSelectedRole().collect { role ->
                if (role.isEmpty()) {
                    val defaultRole = determineDefaultRole()
                    _selectedRole.value = defaultRole
                    repository.saveSelectedRole(defaultRole)
                }
            }
        }
    }

    private val _volunteerList = mutableStateListOf<VolunteerData>()
    val volunteerList: List<VolunteerData>
        get() = _volunteerList

    fun saveVolunteer(volunteer: VolunteerData) {
        _volunteerList.add(volunteer)
    }

    private fun isNetworkConnected(): Boolean {
        val networkCapabilities = connectivityManager.activeNetwork ?: return false
        val activeNetworkInfo = connectivityManager.getNetworkCapabilities(networkCapabilities)
            ?: return false

        return when {
            activeNetworkInfo.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> true
            activeNetworkInfo.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> true
            else -> false
        }
    }
}
