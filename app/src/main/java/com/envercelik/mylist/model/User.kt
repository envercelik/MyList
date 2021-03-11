package com.envercelik.mylist.model

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

/**
 * Represent a table within the database. Room creates a table for each class that has
 * @Entity annotation,the fields in the class correspond to columns in the table.
 */
@Parcelize
@Entity(tableName = "user_table")
data class User(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var uid: Long = 0,
    var firstName: String?,
    var lastName: String?,
    var age: Int?
):Parcelable {

}

