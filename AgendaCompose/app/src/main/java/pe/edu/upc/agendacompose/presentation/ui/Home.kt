package pe.edu.upc.agendacompose.presentation.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import pe.edu.upc.agendacompose.domain.model.Contact


@Preview
@Composable
fun Home() {
    val navController = rememberNavController()
    val contacts = remember {
        mutableStateOf(emptyList<Contact>())
    }

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
                }

            )

        }

        composable("ContactDetail") {
            ContactDetail(contact = selectedContact.value) { contact ->
                contacts.value += contact
                navController.popBackStack()
            }
        }
    }
}