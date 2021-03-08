package com.envercelik.mylist.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

/**
 * Contains the database holder and serves as the main access point for the underlying
 * connection to your's app data.
 */
@Database(entities = [User::class],version = 1, exportSchema = false)
abstract class UserDatabase: RoomDatabase() {

    abstract fun userDao(): UserDao

    /**singleton pattern for database*/
    companion object {

        @Volatile //this field immediately made visible to other thread
        private var INSTANCE: UserDatabase? = null

        fun getDatabase(context: Context):UserDatabase {
            val tempInstance = INSTANCE

            if (tempInstance != null) {
                return tempInstance
            }

            //everything within that block will be protected from a concurrent execution by multiple thread.
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    UserDatabase::class.java,
                    "user_database"
                ).build()

                INSTANCE = instance
                return instance
            }

        }

    }

}