package pe.edu.upc.agendacompose.presentation.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController


@Preview
@Composable
fun Home() {
    val navController= rememberNavController()
    NavHost(navController = navController, startDestination = "ContactList"){

        composable("ContactList") {
            ContactList {
                navController.navigate ("ContactDetail")
            }
        }

        composable("ContactDetail") {
            ContactDetail {
                navController.popBackStack()
            }
        }
    }
}