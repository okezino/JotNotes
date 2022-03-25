package com.example.jotnote.data

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize


@Entity(tableName = "todo_table")
@Parcelize
data class Todo(
    @PrimaryKey
    val id : Int,
    val title : String,
    val status : Boolean,
    val type : Task,
    val description: String,
    val time : String,
    val date : String
) : Parcelable

enum class Task{
    NOTE,
    TODO
}
