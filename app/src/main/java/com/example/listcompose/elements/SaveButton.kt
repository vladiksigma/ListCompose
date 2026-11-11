package com.example.listcompose.elements

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp

@Composable
fun SaveButton(onSaveClick: () -> Unit, active: Boolean){
    Button(onClick = onSaveClick, enabled = active) {
        Text("Сохранить", fontSize = 20.sp)
    }
}