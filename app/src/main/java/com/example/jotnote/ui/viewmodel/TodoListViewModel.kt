package com.example.jotnote.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.jotnote.data.Todo
import com.example.jotnote.domain.RepositoryInterface
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TodoListViewModel @Inject constructor(
    private val repository: RepositoryInterface
) : ViewModel() {

    val todoTitle : String? = null
    val todoDescription : String? = null

    var allTodoItem : LiveData<List<Todo>> = repository.getAllTodos()

    fun insertTodo(todo : Todo){
        viewModelScope.launch {
            repository.insertTodo(todo)
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