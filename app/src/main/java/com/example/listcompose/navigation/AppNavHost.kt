package com.example.listcompose.navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.listcompose.data.AppContainer
import com.example.listcompose.data.Contact
import com.example.listcompose.data.ContactsRepository
import com.example.listcompose.edit.EditRoute
import com.example.listcompose.edit.EditViewModel
import com.example.listcompose.list.ListRoute
import com.example.listcompose.list.ListViewModel
import java.util.UUID


@Composable
fun AppNavHost(){
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "com/example/listcompose/list"){
        composable("com/example/listcompose/list"){
            val viewModel: ListViewModel = viewModel()
            ListRoute(viewModel = viewModel,
                onAddContactClick = {
                    AppContainer.editID = "-1"
                    navController.navigate("com/example/listcompose/edit")
                },
                onEditContactClick = {id ->
                    AppContainer.editID = id
                    navController.navigate("com/example/listcompose/edit")
                }
                )
        }
        composable("com/example/listcompose/edit") {
            val viewModel: EditViewModel = viewModel()
            EditRoute(
                viewModel = viewModel,
                onSaveClick = {
                    if(AppContainer.editID == "-1"){
                        AppContainer.contactsRepository.addContact(Contact(
                            UUID.randomUUID().toString(),
                            viewModel.uiState.value.nameEdit,
                            viewModel.uiState.value.lastNameEdit,
                            viewModel.uiState.value.ageEdit,
                            viewModel.uiState.value.phoneEdit,
                            viewModel.uiState.value.addressEdit,
                            viewModel.uiState.value.siteEdit
                        ))
                    }
                    else{
                    AppContainer.contactsRepository.editContact(AppContainer.editID,
                        Contact(
                        AppContainer.editID,
                        viewModel.uiState.value.nameEdit,
                        viewModel.uiState.value.lastNameEdit,
                        viewModel.uiState.value.ageEdit,
                        viewModel.uiState.value.phoneEdit,
                        viewModel.uiState.value.addressEdit,
                        viewModel.uiState.value.siteEdit
                    )
                    )
                    }
                    navController.navigate("com/example/listcompose/list")
                }
                )
        }
    }
}