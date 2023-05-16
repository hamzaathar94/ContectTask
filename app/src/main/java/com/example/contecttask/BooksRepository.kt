package com.example.contecttask

import androidx.lifecycle.LiveData

class BooksRepository(private val booksDao: BooksDao) {

    suspend fun insertBook(books: Books){
        booksDao.insert(books)
    }

    fun getAllBook():LiveData<List<Books>>{
        return booksDao.getAllBooksData()
    }

    suspend fun deleteBook(books: Books){
        booksDao.deleteBook(books)
    }

    suspend fun updateBook(books: Books){
        booksDao.updateBook(books)
    }

}