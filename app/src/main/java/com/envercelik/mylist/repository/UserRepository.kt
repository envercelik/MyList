package com.envercelik.mylist.repository

import androidx.lifecycle.LiveData
import com.envercelik.mylist.data.UserDao
import com.envercelik.mylist.model.User

/**
 * That class abstracts access to multiple data sources
 */
class UserRepository(private val userDao: UserDao) {

    val getAllUser: LiveData<List<User>> = userDao.getAllUser()

    suspend fun addUser(user: User) {
        userDao.addUser(user)
    }

    suspend fun updateUser(user: User) {
        userDao.updateUser(user)
    }


    suspend fun deleteUser(user: User) {
        userDao.deleteUser(user)
    }


    suspend fun deleteAllUser() {
        userDao.deleteAllUser()
    }
}
