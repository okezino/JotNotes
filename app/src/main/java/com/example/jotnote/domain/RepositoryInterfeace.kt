package com.example.jotnote.domain

import androidx.lifecycle.LiveData
import com.example.jotnote.data.TaskData

interface RepositoryInterface {

    suspend fun insertTodo(task: TaskData)

    suspend fun getTodoById(id : Int) : TaskData?

    suspend fun deleteTodo(todo : TaskData)

    fun getAllTodos() : LiveData<List<TaskData>>
}