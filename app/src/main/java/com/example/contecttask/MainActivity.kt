package com.example.contecttask

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.contecttask.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(),onItemClick {
    private var binding : ActivityMainBinding? = null
    private var viewModel : BooksViewModel? = null
    private var recyclerView : RecyclerView? = null
    private var id : Int? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        recyclerView=binding?.recyclerview
        recyclerView?.layoutManager=LinearLayoutManager(this)

        //viewModel=ViewModelProvider(this)[BooksViewModel::class.java]
        val booksDao=BooksDatabase.getDataBase(applicationContext).daoBook()
        val booksRepository=BooksRepository(booksDao)
        viewModel=ViewModelProvider(this,ViewModelFactory(booksRepository))[BooksViewModel::class.java]
        viewModel?.getBooks()?.observe(this, Observer {
            recyclerView?.adapter=BooksAdapter(this,it,this)
        })

        binding?.btnadd?.setOnClickListener {
            if(binding?.edtxtbookname?.text!!.isEmpty() || binding?.edtxtauthor?.text!!.isEmpty()){
                Toast.makeText(this,"Fields are empty...",Toast.LENGTH_SHORT).show()
            }else {
                val name = binding?.edtxtbookname?.text.toString()
                val author = binding?.edtxtauthor?.text.toString()
                viewModel?.insertBooks(name, author)

                binding?.edtxtbookname?.text?.clear()
                binding?.edtxtauthor?.text?.clear()
            }
        }
        binding?.btnupdate?.setOnClickListener {
            val name=binding?.edtxtbookname?.text.toString()
            val author=binding?.edtxtauthor?.text.toString()
            val books=Books(id.toString().toInt(),name, author)
            viewModel?.updateBook(books)
            binding?.edtxtbookname?.text?.clear()
            binding?.edtxtauthor?.text?.clear()


        }


    }
    override fun onClick( books: Books) {
        binding?.edtxtbookname?.setText(books.name)
        binding?.edtxtauthor?.setText(books.author)
        id = books.Id

        Toast.makeText(this, "$id", Toast.LENGTH_SHORT).show()
    }

    override fun onDeleteUserClickListener(books: Books) {
        viewModel?.deleteBooks(books)
    }

}