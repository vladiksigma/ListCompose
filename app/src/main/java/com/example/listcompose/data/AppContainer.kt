package com.example.listcompose.data

object AppContainer {
    val contactsRepository: ContactsRepository by lazy { ContactsRepository() }
    var editID: String = "0"
}