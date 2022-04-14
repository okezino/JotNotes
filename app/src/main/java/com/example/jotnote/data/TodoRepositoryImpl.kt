package com.example.jotnote.data

import androidx.lifecycle.LiveData
import com.example.jotnote.domain.RepositoryInterface

class TodoRepositoryImpl(private val dao : TodoDao) : RepositoryInterface {
    override suspend fun insertTodo(todo: Todo) {
        dao.insertTodo(todo)
    }

    override suspend fun getTodoById(id: Int): Todo? {
       return  dao.getTodoById(id)
    }

    override suspend fun deleteTodo(todo: Todo) {
        dao.deleteTodo(todo)
    }

    override fun getAllTodos(): LiveData<List<Todo>> {
        return dao.getAllTodos()
    }
}