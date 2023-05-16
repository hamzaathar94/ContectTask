package com.example.contecttask

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
@Entity(tableName = "books")
data class Books(
    @PrimaryKey(autoGenerate = true)var Id : Int?,
    var name : String,
    var author : String?

)
//    ( var name:String,
//     var author:String
//){
//    @PrimaryKey(autoGenerate = true)
//    var id:Int=0
//}
