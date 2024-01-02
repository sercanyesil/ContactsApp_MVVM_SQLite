package com.example.contactsapp.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.contactsapp.data.datasource.ContactsDataSource
import com.example.contactsapp.data.entity.Contacts
import com.example.contactsapp.data.repo.ContactsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomepageViewModel @Inject constructor(var crepo: ContactsRepository) : ViewModel() {
    var contactList = MutableLiveData<List<Contacts>>()

    init {
        loadContacts()
    }

    fun delete(contact_id:Int) {
        CoroutineScope(Dispatchers.Main).launch {
            crepo.delete(contact_id)
            loadContacts()
        }
    }
    fun loadContacts() {
        CoroutineScope(Dispatchers.Main).launch {
            contactList.value = crepo.loadContacts()
        }
    }
    fun search(searchWord: String) {
        CoroutineScope(Dispatchers.Main).launch {
            contactList.value = crepo.search(searchWord)
        }
    }
}