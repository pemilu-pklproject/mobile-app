package com.metromatika.sipemilu.presentation.witness

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.metromatika.sipemilu.presentation.witness.component.WitnessData
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class WitnessViewModel @Inject constructor() : ViewModel() {

    private val _witnessList = mutableStateListOf<WitnessData>()
    val witnessList: List<WitnessData> = _witnessList

    fun addWitness(witnessData: WitnessData) {
        _witnessList.add(witnessData)
    }
}
