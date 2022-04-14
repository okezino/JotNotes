package com.example.jotnote.domain.states

abstract class UseCase<in Params, out Response> {
    abstract suspend fun execute(params: Params) : Response
}