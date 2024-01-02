package com.example.contactsapp.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.contactsapp.data.entity.Contacts

@Database(entities = [Contacts::class], version = 1)
abstract class Database : RoomDatabase() {
    abstract fun getContactsDao() : ContactsDao
}