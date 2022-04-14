package com.example.jotnote.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.jotnote.data.Todo
import com.example.jotnote.domain.RepositoryInterface
import com.example.jotnote.domain.interactors.DeleteTaskUseCase
import com.example.jotnote.domain.interactors.SaveTaskUseCase
import com.example.jotnote.domain.states.AllTodos
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TodoListViewModel @Inject constructor(
    private val repository: RepositoryInterface,
    private val saveTaskUseCase: SaveTaskUseCase,
    private val getAllTaskUseCase: DeleteTaskUseCase
) : ViewModel() {

    var allTodoItem : AllTodos = repository.getAllTodos()

    fun insertTodo(todo : Todo){
        viewModelScope.launch {
            saveTaskUseCase.execute(
                SaveTaskUseCase.Params(todo)
            )
        }

    }

    fun deleteTodo(todo: Todo){
        viewModelScope.launch {
            repository.deleteTodoById(todo)
        }
    }

    fun getTodoById(id: Int){
        viewModelScope.launch {
            repository.getTodoById(id)
        }
    }












}