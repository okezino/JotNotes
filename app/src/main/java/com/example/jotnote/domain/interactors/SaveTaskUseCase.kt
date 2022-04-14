package com.example.jotnote.domain.interactors

import com.example.jotnote.data.TaskData
import com.example.jotnote.domain.RepositoryInterface
import com.example.jotnote.domain.states.UseCase
import javax.inject.Inject

class SaveTaskUseCase @Inject constructor(
    private val todoRepositoryInterface: RepositoryInterface) :
    UseCase<SaveTaskUseCase.Params, Unit>() {
        data class Params(
            val taskData: TaskData
        )

    override suspend fun execute(params: Params) {
        with (params){
            todoRepositoryInterface.insertTodo(taskData)
        }

    }


}