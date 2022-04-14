package com.example.jotnote.presentation.adapter

import android.graphics.Paint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.jotnote.data.Todo
import com.example.jotnote.databinding.TodoLayoutViewBinding

class TodoListViewHolder(private val binding: TodoLayoutViewBinding) : RecyclerView.ViewHolder(binding.root) {


    companion object{
        var onClickInterface: TodoClickInterface? = null
        fun from(parent : ViewGroup) : TodoListViewHolder {
            val layoutInflater = LayoutInflater.from(parent.context)
            val binding = TodoLayoutViewBinding.inflate(layoutInflater,parent,false)
            return TodoListViewHolder(binding)
        }
    }

    fun bind(todo : Todo){
    with(binding){
        cardTitle.text = todo.title
        cardDate.text = todo.date
        cardTime.text = todo.time

        if(todo.status){
            cardTitle.paintFlags = Paint.STRIKE_THRU_TEXT_FLAG
        }

        cardViewTodo.setOnClickListener {
            onClickInterface?.getTodoClicked(todo)
        }


    }


    }
}