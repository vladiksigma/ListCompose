package com.example.listcompose.elements

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType

@Composable
fun EditTextField(
    onValueChange: (String, String) -> Unit,
    field: String,
    label: String,
    value: String,
    keyboard: KeyboardOptions = KeyboardOptions(),
    trailingIcon: @Composable (() -> Unit)? = null
)
{
    OutlinedTextField(
        value = value,
        onValueChange = { onValueChange(field, it) },
        label = { Text(label) },
        singleLine = true,
        keyboardOptions = keyboard,
        modifier = Modifier.fillMaxWidth(0.9f),
        trailingIcon = trailingIcon
    )
}