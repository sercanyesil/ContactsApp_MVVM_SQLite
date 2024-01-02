package com.example.contactsapp.di

import android.content.Context
import androidx.room.Room
import com.example.contactsapp.data.datasource.ContactsDataSource
import com.example.contactsapp.data.repo.ContactsRepository
import com.example.contactsapp.room.ContactsDao
import com.example.contactsapp.room.Database
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    @Provides
    @Singleton
    fun provideContactsDataSource(cdao:ContactsDao) : ContactsDataSource {
        return ContactsDataSource(cdao)
    }

    @Provides
    @Singleton
    fun provideContactsRepository(cds: ContactsDataSource) : ContactsRepository {
        return ContactsRepository(cds)
    }

    @Provides
    @Singleton
    fun provideContactsDao(@ApplicationContext context:Context) : ContactsDao {
        val db = Room.databaseBuilder(context, Database::class.java, "contacts.sqlite")
            .createFromAsset("contacts.sqlite").build()
        return db.getContactsDao()
    }
}