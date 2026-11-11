package com.example.listcompose.list
import com.example.listcompose.data.Contact
data class ListUiState(
    val contactsList: List<Contact> = emptyList()
)