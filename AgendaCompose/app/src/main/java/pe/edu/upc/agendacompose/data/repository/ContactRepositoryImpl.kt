package pe.edu.upc.agendacompose.data.repository

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import pe.edu.upc.agendacompose.domain.model.Contact
import pe.edu.upc.agendacompose.domain.repository.ContactRepository

class ContactRepositoryImpl : ContactRepository {

    private var _contacts = MutableStateFlow<List<Contact>>(emptyList())
    val contacts: StateFlow<List<Contact>> = _contacts

    override fun addContact(contact: Contact) {
        _contacts.value += contact
    }

    override fun deleteContact(contact: Contact) {
        _contacts.value = contacts.value.filterNot { it.id == contact.id }
    }

    override fun updateContact(contact: Contact) {
        _contacts.value = contacts.value.map { if (contact.id == it.id) contact else it }
    }
}