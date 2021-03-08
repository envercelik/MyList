package com.envercelik.mylist.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Represent a table within the database. Room creates a table for each class that has
 * @Entity annotation,the fields in the class correspond to columns in the table.
 */
@Entity(tableName = "user_table")
data class User(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var uid: Long = 0,
    var firstName: String?,
    var lastName: String?,
    var age: Int?
) {

}

