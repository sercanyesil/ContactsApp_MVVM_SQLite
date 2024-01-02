package com.example.contactsapp.data.datasource

import android.util.Log
import com.example.contactsapp.data.entity.Contacts
import com.example.contactsapp.room.ContactsDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ContactsDataSource(var cdao:ContactsDao) {

    suspend fun loadContacts() : List<Contacts> =
        withContext(Dispatchers.IO) {
            return@withContext cdao.loadContacts()
        }

    suspend fun search(searchWord: String) : List<Contacts> =
        withContext(Dispatchers.IO) {
            return@withContext cdao.search(searchWord)
        }

    suspend fun save(contact_name: String, contact_number: String) {
        val newContact = Contacts(0,contact_name,contact_number)
        cdao.save(newContact)
    }

    suspend fun update(contact_id:Int, contact_name: String, contact_number: String) {
        val updatedContact = Contacts(contact_id,contact_name,contact_number)
        cdao.update(updatedContact)
    }

    suspend fun delete(contact_id:Int) {
        val deletedContact = Contacts(contact_id,"", "")
        cdao.delete(deletedContact)
    }
}