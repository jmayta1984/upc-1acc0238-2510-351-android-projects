package pe.edu.upc.agendacompose.presentation.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Save
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import pe.edu.upc.agendacompose.domain.model.Contact

@Preview
@Composable
fun ContactDetail(
    modifier: Modifier = Modifier,
    contact: Contact? = null,
    onSave: (Contact) -> Unit = {}
) {
    val name = remember {
        mutableStateOf(contact?.name ?: "")
    }

    val phone = remember {
        mutableStateOf(contact?.phone ?: "")
    }

    val company = remember {
        mutableStateOf(contact?.company ?: "")
    }

    Scaffold(
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    val id = contact?.id ?: (0..99).random()
                    onSave(
                        Contact(
                            id = id,
                            name = name.value,
                            phone = phone.value,
                            company = company.value
                        )
                    )
                }
            ) {
                Icon(Icons.Default.Save, contentDescription = null)
            }
        }

    ) { padding ->
        Column(
            modifier = modifier
                .fillMaxSize()
                .padding(padding),
            verticalArrangement = Arrangement.Center
        )
        {
            OutlinedTextField(
                modifier = modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                placeholder = {
                    Text("Name")
                },
                value = name.value,
                onValueChange = {
                    name.value = it
                }
            )

            OutlinedTextField(
                modifier = modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                placeholder = {
                    Text("Phone")
                },
                value = phone.value,
                onValueChange = {
                    phone.value = it
                })

            OutlinedTextField(
                modifier = modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                placeholder = {
                    Text("Company")
                },
                value = company.value,
                onValueChange = {
                    company.value = it
                })

        }
    }

}