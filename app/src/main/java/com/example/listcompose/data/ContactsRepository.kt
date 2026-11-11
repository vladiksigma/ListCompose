package com.example.listcompose.data

import androidx.room.util.copy
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class ContactsRepository {


        private val _contacts = MutableStateFlow( listOf(
            Contact(
                id = "0",
                name = "Pavel",
                lastName = "Mazko",
                age = "22",
                phoneNumber = "+79512722302",
                address = "Moscow",
                site = "yandex.ru"
            ),
            Contact(
                id = "1",
                name = "Anna",
                lastName = "Ivanova",
                age = "28",
                phoneNumber = "+79123456789",
                address = "Saint Petersburg",
                site = "vk.com"
            ),
            Contact(
                id = "2",
                name = "Dmitry",
                lastName = "Sokolov",
                age = "35",
                phoneNumber = "+79031234567",
                address = "Novosibirsk",
                site = "mail.ru"
            ),
            Contact(
                id = "3",
                name = "Elena",
                lastName = "Kuznetsova",
                age = "19",
                phoneNumber = "+79998887766",
                address = "Kazan",
                site = "google.com"
            ),
            Contact(
                id = "4",
                name = "Maxim",
                lastName = "Petrov",
                age = "41",
                phoneNumber = "+79261112233",
                address = "Yekaterinburg",
                site = "rambler.ru"
            ),
            Contact(
                id = "5",
                name = "Olga",
                lastName = "Smirnova",
                age = "26",
                phoneNumber = "+79654445566",
                address = "Sochi",
                site = "yandex.ru"
            )
        ))

    val contacts: StateFlow<List<Contact>> = _contacts.asStateFlow()

    fun getById(id: String): Contact?{
        return _contacts.value.find { it.id == id }
    }

    fun editContact(id: String, value: Contact) {
        _contacts.update { currentList ->
            currentList.map { contact ->
                if (contact.id == id) value else contact
            }
        }
    }

    fun addContact(value: Contact){
        _contacts.update { it + value}
    }
}