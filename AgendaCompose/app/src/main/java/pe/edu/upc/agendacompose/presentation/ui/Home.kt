package pe.edu.upc.agendacompose.presentation.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import pe.edu.upc.agendacompose.data.repository.ContactRepositoryImpl
import pe.edu.upc.agendacompose.domain.model.Contact
import pe.edu.upc.agendacompose.domain.repository.ContactRepository
import pe.edu.upc.agendacompose.domain.usecase.AddContactUseCase
import pe.edu.upc.agendacompose.domain.usecase.DeleteContactUseCase
import pe.edu.upc.agendacompose.domain.usecase.UpdateContactUseCase


@Preview
@Composable
fun Home() {
    val navController = rememberNavController()
    val repository = ContactRepositoryImpl()
    val addContactUseCase = AddContactUseCase(repository)
    val updateContactUseCase = UpdateContactUseCase(repository)
    val deleteContactUseCase = DeleteContactUseCase(repository)

    val contacts = repository.contacts.collectAsState()

    val selectedContact = remember {
        mutableStateOf<Contact?>(null)
    }


    NavHost(navController = navController, startDestination = "ContactList") {

        composable("ContactList") {
            ContactList(
                contacts = contacts.value,
                onAdd = {
                    selectedContact.value = null
                    navController.navigate("ContactDetail")
                },
                onSelect = { contact ->
                    selectedContact.value = contact
                    navController.navigate("ContactDetail")
                },
                onDelete = { contact ->
                    deleteContactUseCase(contact)
                }
            )
        }

        composable("ContactDetail") {
            ContactDetail(contact = selectedContact.value) { contact ->


                if (selectedContact.value == null) {
                    addContactUseCase(contact)
                } else {
                    updateContactUseCase(contact)
                }
                navController.popBackStack()
            }
        }
    }
}