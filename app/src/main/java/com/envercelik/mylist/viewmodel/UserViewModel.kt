package com.envercelik.mylist.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.envercelik.mylist.data.UserDatabase
import com.envercelik.mylist.repository.UserRepository
import com.envercelik.mylist.model.User
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

/**
 * This class provide data to the UI and survive configuration changes. A ViewModel
 * acts as a communication center between the Repository and the UI.
 */
class UserViewModel(application: Application): AndroidViewModel(application) {

    val getAllUser: LiveData<List<User>>
    private val repository: UserRepository

    //always first executed when UserViewModel is called.
    init {
        val userDao = UserDatabase.getDatabase(application).userDao()
        repository = UserRepository(userDao)
        getAllUser = repository.getAllUser
    }


    //add user with coroutine inside the background thread.
    fun addUser(user: User) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.addUser(user)
        }
    }


    //update user with coroutine inside the background thread.
    fun updateUser(user: User) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.updateUser(user)
        }
    }

}