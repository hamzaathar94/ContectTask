package com.example.contecttask

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface BooksDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(books: Books)

    @Query("SELECT * FROM books ORDER BY id asc")
    fun getAllBooksData(): LiveData<List<Books>>

    @Update
    fun updateBook(books: Books)

    @Delete
    fun deleteBook(books: Books)

}