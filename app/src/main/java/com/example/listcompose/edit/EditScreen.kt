package com.example.listcompose.edit

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.Place
import androidx.compose.material.icons.filled.Send
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.listcompose.elements.ContactsListItem
import com.example.listcompose.elements.EditTextField
import com.example.listcompose.elements.SaveButton
import com.example.listcompose.list.ListViewModel
import com.example.listcompose.openAddress
import com.example.listcompose.openPhone
import com.example.listcompose.openSite

@Composable
fun EditRoute(
    viewModel: EditViewModel,
    onSaveClick: () -> Unit
){

    val uiState by viewModel.uiState.collectAsStateWithLifecycle()
    EditContent(uiState, onSaveClick, viewModel::onInputChange)
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EditContent(
    uiState: EditUiState,
    onSaveClick: () -> Unit,
    onEdit: (String, String) -> Unit
){
    val context = LocalContext.current

    Scaffold(
        topBar = {
            TopAppBar(title = { Text("Введите данные") })
        },

    ) { paddingValues ->
        Column(
            modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues),
            horizontalAlignment = Alignment.CenterHorizontally
        )
        {


            Spacer(modifier = Modifier.height(20.dp))
            EditTextField(
                onValueChange = onEdit,
                label = "ИМЯ",
                field = "NAME",
                value = uiState.nameEdit
            )
            Spacer(modifier = Modifier.height(20.dp))
            EditTextField(
                onValueChange = onEdit,
                label = "ФАМИЛИЯ",
                field = "LASTNAME",
                value = uiState.lastNameEdit
            )
            Spacer(modifier = Modifier.height(20.dp))
            EditTextField(
                onValueChange = onEdit,
                label = "ВОЗРАСТ",
                field = "AGE",
                value = uiState.ageEdit,
                keyboard = KeyboardOptions(keyboardType = KeyboardType.Number)
            )
            Spacer(modifier = Modifier.height(20.dp))
            EditTextField(
                onValueChange = onEdit,
                label = "НОМЕР ТЕЛЕФОНА",
                field = "PHONE",
                value = uiState.phoneEdit,
                keyboard = KeyboardOptions(keyboardType = KeyboardType.Number),
                trailingIcon = {
                    if (uiState.phoneEdit.isNotBlank()) {
                        IconButton(onClick = { openPhone(context, uiState.phoneEdit) }) {
                            Icon(Icons.Default.Phone, contentDescription = "позвонить")
                        }
                    }
                }
            )
            Spacer(modifier = Modifier.height(20.dp))
            EditTextField(
                onValueChange = onEdit,
                label = "АДРЕС",
                field = "ADDRESS",
                value = uiState.addressEdit,
                trailingIcon = {
                    if (uiState.addressEdit.isNotBlank()) {
                        IconButton(onClick = { openAddress(context, uiState.addressEdit) }) {
                            Icon(Icons.Default.Place, contentDescription = "карты")
                        }
                    }
                }
            )
            Spacer(modifier = Modifier.height(20.dp))
            EditTextField(
                onValueChange = onEdit,
                label = "САЙТ",
                field = "SITE",
                value = uiState.siteEdit,
                trailingIcon = {
                    if (uiState.siteEdit.isNotBlank()) {
                        IconButton(onClick = { openSite(context, uiState.siteEdit) }) {
                            Icon(Icons.Default.Send, contentDescription = "сайт")
                        }
                    }
                }
            )
            Spacer(modifier = Modifier.height(20.dp))
            SaveButton(onSaveClick = onSaveClick, uiState.isSaveEnabled)
        }


    }
}