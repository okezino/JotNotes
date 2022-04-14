package com.example.jotnote.domain

open class BaseRepositoryService {

    suspend fun <T> executeRequest(request : suspend () -> T) : T {
        return request()
    }

   fun <T> executeRequests(request :  () -> T) : T {
        return request()
    }
}