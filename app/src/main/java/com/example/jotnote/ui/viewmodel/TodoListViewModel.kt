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

    private val _allTodoItem = MutableLiveData<List<Todo>>()
    val allTodoItem : LiveData<List<Todo>>
        get() {
           return  _allTodoItem
        }

    private val _getTodoItem = MutableLiveData<Todo>()
    val getTodoItem : LiveData<Todo>
        get() {
            return  _getTodoItem
        }



    fun getAllTodoItem(){
        viewModelScope.launch {
          repository.getAllTodos().collect {
               _allTodoItem.value = it
           }
        }
    }

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