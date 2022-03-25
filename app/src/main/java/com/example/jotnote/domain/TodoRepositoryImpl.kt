package com.example.jotnote.domain

import com.example.jotnote.data.Todo
import com.example.jotnote.data.TodoDao
import kotlinx.coroutines.flow.Flow

class TodoRepositoryImpl(
    private val dao : TodoDao
) : RepositoryInterface {
    override suspend fun insertTodo(todo: Todo) {
        TODO("Not yet implemented")
    }

    override suspend fun getTodoById(id: Int): Todo? {
        TODO("Not yet implemented")
    }

    override suspend fun deleteTodoById(todo: Todo) {
        TODO("Not yet implemented")
    }

    override fun getAllTodos(): Flow<List<Todo>> {
        TODO("Not yet implemented")
    }
}