package com.example.jotnote.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.jotnote.common.ExceptionHandler
import com.example.jotnote.data.TaskData
import com.example.jotnote.domain.interactors.DeleteTaskUseCase
import com.example.jotnote.domain.interactors.GetAllTaskUseCase
import com.example.jotnote.domain.interactors.SaveTaskUseCase
import com.example.jotnote.domain.states.AllTasks
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TaskListViewModel @Inject constructor(
    getAllTaskUseCase: GetAllTaskUseCase,
    private val deleteTaskUseCase: DeleteTaskUseCase,
    private val saveTaskUseCase: SaveTaskUseCase,

) : ViewModel() {

    var allTodoItem : AllTasks = getAllTaskUseCase.execute(Unit).tasks

    fun insertTodo(taskData: TaskData){
        viewModelScope.launch {
            try{
                saveTaskUseCase.execute(
                    SaveTaskUseCase.Params(taskData)
                )
            }catch (e : Exception){
                ExceptionHandler(e).logException()
            }

        }

    }

    fun deleteTask(taskData: TaskData){
        viewModelScope.launch {
            try{
                saveTaskUseCase.execute(
                    SaveTaskUseCase.Params(taskData)
                )
            }catch (e : Exception){
                ExceptionHandler(e).logException()
            }

        }
    }











}