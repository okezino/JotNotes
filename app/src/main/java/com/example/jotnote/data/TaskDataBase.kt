package com.example.jotnote.data

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [TaskData::class], version = 1
)
abstract class TaskDataBase : RoomDatabase() {
    abstract val dao : TaskDao
}