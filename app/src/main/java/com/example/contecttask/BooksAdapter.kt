package com.example.contecttask

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.contecttask.databinding.BookItemBinding

class BooksAdapter(var context: Context,val data: List<Books>,val onclick: onItemClick)
    :RecyclerView.Adapter<BooksAdapter.MyViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding=BookItemBinding.inflate(LayoutInflater.from(context),parent,false)
        return MyViewHolder(binding, onclick)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val std=data[position]
        holder.binding.txtbookname.text=std.name.toString()
        holder.binding.txtauthor.text=std.author.toString()
        holder.itemView.setOnClickListener(View.OnClickListener {
            onclick.onClick(std)
        })
        holder.bind(std)

    }
    class MyViewHolder(var binding: BookItemBinding,var onclick: onItemClick):
        RecyclerView.ViewHolder(binding.root){

        val name= binding.txtbookname
        val author=binding.txtauthor

        fun bind(books: Books){
            name.text=books.name
            author.text=books.author
            binding.imageView2.setOnClickListener {
                onclick.onDeleteUserClickListener(books)
            }
        }

    }
}