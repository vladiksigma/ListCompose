package com.example.listcompose.edit

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.room.util.copy
import com.example.listcompose.data.AppContainer
import com.example.listcompose.data.Contact
import com.example.listcompose.data.ContactsRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class EditViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(EditUiState())
    val uiState: StateFlow<EditUiState> = _uiState.asStateFlow()
    private val repository: ContactsRepository = AppContainer.contactsRepository

    init {
        viewModelScope.launch {
            var con: Contact? = repository.getById(AppContainer.editID)
            _uiState.value = EditUiState(nameEdit = con?.name ?: "", lastNameEdit = con?.lastName ?: "", ageEdit = con?.age ?: "", phoneEdit = con?.phoneNumber ?: "", addressEdit = con?.address ?: "", siteEdit = con?.site ?: "")
        }
    }

    fun onInputChange(field: String,text: String) {

        when (field) {
            "NAME" -> _uiState.update { it.copy(nameEdit = text) }
            "LASTNAME" -> _uiState.update { it.copy(lastNameEdit = text) }
            "AGE" -> _uiState.update { it.copy(ageEdit = text.filter { it.isDigit() }) }
            "PHONE" -> _uiState.update { it.copy(phoneEdit = text.filter { it.isDigit() }) }
            "ADDRESS" -> _uiState.update { it.copy(addressEdit = text) }
            "SITE" -> _uiState.update { it.copy(siteEdit = text) }
        }
    }




}