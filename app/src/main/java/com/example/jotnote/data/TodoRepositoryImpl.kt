package com.example.jotnote.data

import androidx.lifecycle.LiveData
import com.example.jotnote.domain.BaseRepositoryService
import com.example.jotnote.domain.RepositoryInterface



class TodoRepositoryImpl(private val dao: TodoDao) : RepositoryInterface, BaseRepositoryService() {
    override suspend fun insertTodo(todo: Todo) {
        dao.insertTodo(todo)
    }

    override suspend fun getTodoById(id: Int): Todo? = executeRequest {
        try {
            dao.getTodoById(id)
        } catch (e: Exception) {
            throw e
        }
    }

    override suspend fun deleteTodo(todo: Todo) {
        dao.deleteTodo(todo)
    }

    override fun getAllTodos(): LiveData<List<Todo>> = executeRequests{
        try {
            dao.getAllTodos()
        }catch (e : Exception){
            throw e
        }
    }
}