package com.example.jotnote.data

import androidx.lifecycle.LiveData
import com.example.jotnote.domain.BaseRepositoryService
import com.example.jotnote.domain.RepositoryInterface



class TaskRepositoryImpl(private val dao: TaskDao) : RepositoryInterface, BaseRepositoryService() {
    override suspend fun insertTodo(taskData: TaskData) {
        dao.insertTodo(taskData)
    }

    override suspend fun getTodoById(id: Int): TaskData? = executeRequest {
        try {
            dao.getTodoById(id)
        } catch (e: Exception) {
            throw e
        }
    }

    override suspend fun deleteTodo(todo: TaskData) {
        dao.deleteTodo(todo)
    }

    override fun getAllTodos(): LiveData<List<TaskData>> = executeRequests{
        try {
            dao.getAllTodos()
        }catch (e : Exception){
            throw e
        }
    }
}