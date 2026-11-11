package com.example.listcompose.list

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.listcompose.elements.ContactsListItem
import com.example.listcompose.list.ListUiState
import com.example.listcompose.list.ListViewModel

@Composable
fun ListRoute(
    viewModel: ListViewModel,
    onAddContactClick: () -> Unit,
    onEditContactClick: (String) -> Unit
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    ListContent(
        uiState = uiState,
        onAddContactClick = onAddContactClick,
        onEditContactClick = onEditContactClick
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ListContent(
    uiState: ListUiState,
    onAddContactClick: () -> Unit,
    onEditContactClick: (String) -> Unit
) {
    Scaffold(
        topBar = {
            TopAppBar(title = { Text("Контакты") })
        },
        floatingActionButton = {
            FloatingActionButton(onClick = onAddContactClick) {
                Icon(Icons.Default.Add, contentDescription = "Добавить контак")
            }
        }
    ) { paddingValues ->

            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues),
                contentPadding = PaddingValues(16.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(uiState.contactsList, key = { it.id }) { contact ->
                    ContactsListItem(
                        contact = contact,
                        onEditClick = { onEditContactClick(contact.id) }
                    )
                }
            }
        }

}

