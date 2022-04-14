package com.example.jotnote.domain.states

abstract class MainUseCase<in Params, out Response> {
    abstract fun execute(params: Params) : Response
}