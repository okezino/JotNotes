package com.example.jotnote.domain.interactors

import com.example.jotnote.domain.RepositoryInterface
import com.example.jotnote.domain.states.AllTodos
import com.example.jotnote.domain.states.MainUseCase
import javax.inject.Inject

class GetAllTaskUseCase @Inject constructor(
    private val todoRepositoryInterface: RepositoryInterface
) : MainUseCase<Unit, GetAllTaskUseCase.Response>() {
    data class Response(
       val  todos : AllTodos
    )

    override fun execute(params: Unit): Response = Response(
      todoRepositoryInterface.getAllTodos()
    )

}