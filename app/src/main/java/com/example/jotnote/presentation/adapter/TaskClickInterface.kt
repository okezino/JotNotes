package com.example.jotnote.presentation.adapter

import com.example.jotnote.data.TaskData


interface TaskClickInterface {
    fun getTodoClicked(taskData: TaskData)
}