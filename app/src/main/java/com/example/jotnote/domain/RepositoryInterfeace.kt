package com.example.jotnote.domain

import com.example.jotnote.data.Todo
import kotlinx.coroutines.flow.Flow

interface RepositoryInterface {

    suspend fun insertTodo(todo: Todo)

    suspend fun getTodoById(id : Int) : Todo?

    suspend fun deleteTodoById(todo : Todo)

    fun getAllTodos() : Flow<List<Todo>>
}