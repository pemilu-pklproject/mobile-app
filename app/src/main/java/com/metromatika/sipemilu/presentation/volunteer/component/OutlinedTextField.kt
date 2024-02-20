package com.metromatika.sipemilu.presentation.volunteer.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OutlinedTextField(
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
