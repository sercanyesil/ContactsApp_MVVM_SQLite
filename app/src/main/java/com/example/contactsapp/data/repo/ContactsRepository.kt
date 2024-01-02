package com.example.contactsapp.data.repo

import com.example.contactsapp.data.datasource.ContactsDataSource
import com.example.contactsapp.data.entity.Contacts

class ContactsRepository(var cds:ContactsDataSource) {

    suspend fun save(contact_name: String, contact_number: String) = cds.save(contact_name, contact_number)

    suspend fun update(contact_id:Int, contact_name: String, contact_number: String) = cds.update(contact_id, contact_name, contact_number)

    suspend fun delete(contact_id:Int) = cds.delete(contact_id)

    suspend fun loadContacts() : List<Contacts> = cds.loadContacts()

    suspend fun search(searchWord: String) : List<Contacts> = cds.search(searchWord)
}