package com.example.jotnote.domain.interactors

import com.example.jotnote.data.TaskData
import com.example.jotnote.domain.RepositoryInterface
import com.example.jotnote.domain.states.UseCase
import javax.inject.Inject


class DeleteTaskUseCase @Inject constructor(
    private val todoRepositoryInterface: RepositoryInterface
) : UseCase<DeleteTaskUseCase.Params, Unit>() {


    data class Params(
        val todo : TaskData
    )

    override suspend fun execute(params: Params){
        with(params){
            todoRepositoryInterface.deleteTodo(todo)
        }

    }


}
