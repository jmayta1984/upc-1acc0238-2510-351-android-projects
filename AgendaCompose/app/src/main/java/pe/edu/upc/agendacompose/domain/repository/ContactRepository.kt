package pe.edu.upc.agendacompose.domain.repository

import pe.edu.upc.agendacompose.domain.model.Contact

interface ContactRepository {
    fun addContact(contact: Contact)
    fun deleteContact(contact: Contact)
    fun updateContact(contact: Contact)
}