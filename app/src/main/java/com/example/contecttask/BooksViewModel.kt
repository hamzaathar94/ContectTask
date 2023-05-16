package com.example.contecttask

import android.app.Application
import android.content.Context
import android.os.AsyncTask
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class BooksViewModel(private val booksRepository: BooksRepository):ViewModel(){

    fun getBooks():LiveData<List<Books>>{
        return booksRepository.getAllBook()
    }
    fun insertBooks(name:String,author:String){
        viewModelScope.launch (Dispatchers.IO){
            val books=Books(null,name,author)
            booksRepository.insertBook(books)
        }
    }
    fun deleteBooks(books: Books){
        viewModelScope.launch (Dispatchers.IO){
            booksRepository.deleteBook(books)
        }
    }
    fun updateBook(books: Books){
        viewModelScope.launch(Dispatchers.IO){
            booksRepository.updateBook(books)
        }
    }
//    var booksDao=BooksDatabase.getDataBase(application).daoBook()
//    val book:LiveData<List<Books>> = booksDao.getAllBooksData()
//
//    init {
//        val db=BooksDatabase.getDataBase(application)
//        booksDao=db.daoBook()
//    }
//    fun getAllBook(){
//        val daoBook= BooksDatabase.getDataBase(getApplication()).daoBook()
//        val list=daoBook.getAllBooksData()
//    }
//
//    fun insertBook(name:String,author:String){
//        GlobalScope.launch {
//            val data= Books(null,name, author)
//            booksDao.insert(data)
//        }
//    }
//
//    fun updateBook(books: Books){
//        GlobalScope.launch {
//            val data=Books(books.Id,books.name,books.author)
//            booksDao.updateBook(data)
//        }
//    }
//
//    fun deleteBook(books: Books){
//        GlobalScope.launch {
//            booksDao.deleteBook(books)
//        }
//    }
}