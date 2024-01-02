package com.example.contactsapp.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.contactsapp.data.entity.Contacts

@Dao
interface ContactsDao {
    @Query("SELECT * FROM contacts")
    suspend fun loadContacts() : List<Contacts>

    @Insert
    suspend fun save(contact:Contacts)

    @Update
    suspend fun update(contact:Contacts)

    @Delete
    suspend fun delete(contact:Contacts)

    @Query("SELECT * FROM contacts WHERE contact_name like '%' || :searchWord || '%'")
    suspend fun search(searchWord: String) : List<Contacts>
}