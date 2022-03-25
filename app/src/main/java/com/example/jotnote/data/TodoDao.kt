package com.example.jotnote.data

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface TodoDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTodo(todo: Todo)

    @Query("SELECT * FROM todo_table WHERE id = :id")
    suspend fun getTodoById(id : Int) : Todo?

    @Delete()
    suspend fun deleteTodoById(todo : Todo)

    @Query("SELECT * FROM todo_table")
    fun getAllTodos() : Flow<List<Todo>>
}