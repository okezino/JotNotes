package com.example.jotnote.util

fun todoInputValidation(reminder : Boolean, input : Boolean) : String{
    var string = "Success"
   if(!input){
      string = "Todo is needed"
   }
   if(!reminder) {
       string = "Reminder date and Time is needed"
   }

    return string


}