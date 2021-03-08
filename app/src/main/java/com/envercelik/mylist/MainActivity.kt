package com.envercelik.mylist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}


/*
- Room library is built on top of SQLite open-helper class.

Advantages :

- Compile time verification of SQL queries.
- Less boilerplate code
- Easily integrated with other Architecture components like LiveData


There are three main component of room Database:

@Entity --> Represent a table within the database. Room creates a table for each class that has
            @Entity annotation,the fields in the class correspond to columns in the table.

@Dao --> DAOs are responsible for defining the methods that access the database.

@Database --> Contains the database holder and serves as the main access point for the underlying
              connection to your's app data.





*/