package com.example.jotnote.util

import android.util.Log
import java.lang.Exception

private const val TAG = "ExceptionHandler"
open class ExceptionHandler(private val  exception: Exception ) {

    fun logException(){
        Log.d(TAG,exception.localizedMessage)
    }
}