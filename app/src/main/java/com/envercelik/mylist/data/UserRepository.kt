package com.envercelik.mylist.data

import androidx.lifecycle.LiveData

/**
 * That class abstracts access to multiple data sources
 */
class UserRepository(private val userDao: UserDao) {

    val getAllUser: LiveData<List<User>> = userDao.getAllUser()

    suspend fun addUser(user: User) {
        userDao.addUser(user)
    }
}
