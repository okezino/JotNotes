package com.example.jotnote.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.jotnote.data.TaskData
import com.example.jotnote.domain.RepositoryInterface
import com.example.jotnote.domain.interactors.GetAllTaskUseCase
import com.example.jotnote.domain.interactors.SaveTaskUseCase
import com.example.jotnote.domain.states.AllTasks
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TaskListViewModel @Inject constructor(
    private val repository: RepositoryInterface,
    private val saveTaskUseCase: SaveTaskUseCase,
    private val getAllTaskUseCase: GetAllTaskUseCase
) : ViewModel() {

    var allTodoItem : AllTasks = getAllTaskUseCase.execute(Unit).tasks

    fun insertTodo(taskData: TaskData){
        viewModelScope.launch {
            saveTaskUseCase.execute(
                SaveTaskUseCase.Params(taskData)
            )
        }

    }

    fun deleteTodo(taskData: TaskData){
        viewModelScope.launch {
            repository.deleteTodo(taskData)
        }
    }











}