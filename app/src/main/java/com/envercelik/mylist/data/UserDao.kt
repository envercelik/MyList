package com.envercelik.mylist.data

import androidx.lifecycle.LiveData
import androidx.room.*
import com.envercelik.mylist.model.User


/**
 * DAOs are responsible for defining the methods that access the database.
 */
@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addUser(user: User)

    @Update
    suspend fun updateUser(user: User)

    @Delete
    suspend fun deleteUser(user: User)

    @Query("DELETE FROM user_table")
    suspend fun deleteAllUser()


    @Query("SELECT * FROM user_table ORDER BY id ASC")
    fun getAllUser() : LiveData<List<User>>
}