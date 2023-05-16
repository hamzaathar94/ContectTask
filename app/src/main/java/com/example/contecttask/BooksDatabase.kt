package com.example.contecttask

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [(Books::class)], version = 1, exportSchema = false)
abstract class BooksDatabase:RoomDatabase() {
    abstract fun daoBook():BooksDao
    companion object{
        private var INSTANCE:BooksDatabase?=null

        fun getDataBase(context: Context):BooksDatabase{
            if (INSTANCE==null){
              synchronized(this){
                  INSTANCE=Room.databaseBuilder(
                      context,
                      BooksDatabase::class.java,
                      "book_database"
                  ).build()
              }
            }
            return INSTANCE!!
        }
    }



}