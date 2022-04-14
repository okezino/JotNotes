package com.example.jotnote.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.jotnote.data.Todo
import com.example.jotnote.domain.RepositoryInterface
import com.example.jotnote.domain.interactors.GetAllTaskUseCase
import com.example.jotnote.domain.interactors.SaveTaskUseCase
import com.example.jotnote.domain.states.AllTodos
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TaskListViewModel @Inject constructor(
    private val repository: RepositoryInterface,
    private val saveTaskUseCase: SaveTaskUseCase,
    private val getAllTaskUseCase: GetAllTaskUseCase
) : ViewModel() {

    var allTodoItem : AllTodos = getAllTaskUseCase.execute(Unit).todos

    fun insertTodo(todo : Todo){
        viewModelScope.launch {
            saveTaskUseCase.execute(
                SaveTaskUseCase.Params(todo)
            )
        }

    }

    fun deleteTodo(todo: Todo){
        viewModelScope.launch {
            repository.deleteTodo(todo)
        }
    }











}