package com.example.jotnote.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface TaskDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTodo(taskData: TaskData)

    @Query("SELECT * FROM task_table WHERE id = :id")
    suspend fun getTodoById(id : Int) : TaskData?

    @Delete()
    suspend fun deleteTodo(taskData : TaskData)

    @Query("SELECT * FROM task_table")
    fun getAllTodos() : LiveData<List<TaskData>>
}