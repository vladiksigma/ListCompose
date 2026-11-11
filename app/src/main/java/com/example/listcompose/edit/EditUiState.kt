package com.example.listcompose.edit

data class EditUiState(
    val nameEdit: String = "",
    val lastNameEdit: String = "",
    val ageEdit: String = "",
    val phoneEdit: String = "",
    val addressEdit: String = "",
    val siteEdit: String = ""
)
{
    val isSaveEnabled: Boolean
        get() = nameEdit.isNotBlank() &&
                lastNameEdit.isNotBlank() &&
                ageEdit.isNotBlank()
}