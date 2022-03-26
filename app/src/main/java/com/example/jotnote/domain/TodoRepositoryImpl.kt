package com.example.jotnote.domain

import com.example.jotnote.data.Todo
import com.example.jotnote.data.TodoDao
import kotlinx.coroutines.flow.Flow

class TodoRepositoryImpl(
    private val dao : TodoDao
) : RepositoryInterface {
    override suspend fun insertTodo(todo: Todo) {
        dao.insertTodo(todo)
    }

    override suspend fun getTodoById(id: Int): Todo? {
       return  dao.getTodoById(id)
    }

    override suspend fun deleteTodoById(todo: Todo) {
        dao.deleteTodoById(todo)
    }

    override fun getAllTodos(): Flow<List<Todo>> {
        return dao.getAllTodos()
    }
}