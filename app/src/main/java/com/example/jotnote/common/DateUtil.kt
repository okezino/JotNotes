package com.example.jotnote.common

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.content.Context
import com.example.jotnote.R
import java.text.SimpleDateFormat
import java.util.*

fun getDatePicker(context: Context, getDate:(string : String) -> Unit){
    val cal = Calendar.getInstance()
    val datePickerDialog = DatePickerDialog(context,R.style.DialogTheme,
        { _, year, month, dayOfMonth ->
            val date = "${month + 1}/$dayOfMonth/$year"
            if(date.isNotBlank()) getDate(date)
        }, cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), cal.get(Calendar.DAY_OF_MONTH))
    datePickerDialog.show()

}


fun getTime(context: Context, getTime:(time : String) -> Unit){
    val cal = Calendar.getInstance()
    val timeSetListener = TimePickerDialog.OnTimeSetListener { _, hour, minute ->
        cal.set(Calendar.HOUR_OF_DAY, hour)
        cal.set(Calendar.MINUTE, minute)
        getTime(SimpleDateFormat("hh:mm a").format(cal.time))
    }
    TimePickerDialog(context, timeSetListener, cal.get(Calendar.HOUR_OF_DAY), cal.get(Calendar.MINUTE), true).show()
}
