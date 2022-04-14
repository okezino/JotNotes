package com.example.jotnote.data

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize


@Entity(tableName = "todo_table")
@Parcelize
data class TaskData(
    @PrimaryKey(autoGenerate = true)
    val id : Int? = null,
    val title : String,
    val status : Boolean,
    val type : TaskType,
    val description: String,
    val time : String,
    val date : String
) : Parcelable

enum class TaskType{
    NOTE,
    TODO
}
