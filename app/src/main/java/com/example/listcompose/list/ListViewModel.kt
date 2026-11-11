package com.example.listcompose.list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.listcompose.data.AppContainer
import com.example.listcompose.data.ContactsRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

import kotlinx.coroutines.launch


class ListViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(ListUiState())
    val uiState: StateFlow<ListUiState> = _uiState.asStateFlow()
    private val repository: ContactsRepository = AppContainer.contactsRepository

    init {
        viewModelScope.launch { repository.contacts.collect { contactsList ->
            _uiState.value = ListUiState(contactsList = contactsList) }
        }
    }


}