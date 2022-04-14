package com.example.jotnote.domain

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.jotnote.data.Todo
import kotlinx.coroutines.flow.Flow

interface RepositoryInterface {

    suspend fun insertTodo(todo: Todo)

    suspend fun getTodoById(id : Int) : Todo?

    suspend fun deleteTodo(todo : Todo)

    fun getAllTodos() : LiveData<List<Todo>>
}