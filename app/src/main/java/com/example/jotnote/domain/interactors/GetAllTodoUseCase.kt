package com.example.jotnote.domain.interactors

import com.example.jotnote.domain.RepositoryInterface
import com.example.jotnote.domain.states.AllTodos
import com.example.jotnote.domain.states.MainUseCase
import javax.inject.Inject

class GetAllTodoUseCase @Inject constructor(
    private val todoRepositoryInterface: RepositoryInterface
) : MainUseCase<Unit, GetAllTodoUseCase.Response>() {
    data class Response(
      private val  todo : AllTodos
    )

    override fun execute(params: Unit): Response = Response(
      todoRepositoryInterface.getAllTodos()
    )

}