package com.example.jotnote.presentation.adapter

import android.graphics.Paint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.jotnote.data.TaskData
import com.example.jotnote.databinding.TodoLayoutViewBinding

class TaskListViewHolder(private val binding: TodoLayoutViewBinding) :
    RecyclerView.ViewHolder(binding.root) {


    companion object {
        var onClickInterface: TaskClickInterface? = null
        fun from(parent: ViewGroup): TaskListViewHolder {
            val layoutInflater = LayoutInflater.from(parent.context)
            val binding = TodoLayoutViewBinding.inflate(layoutInflater, parent, false)
            return TaskListViewHolder(binding)
        }
    }

    fun bind(task: TaskData) {
        with(binding) {
            cardTitle.text = task.title
            cardDate.text = task.date
            cardTime.text = task.time

            if (task.status) {
                cardTitle.paintFlags = Paint.STRIKE_THRU_TEXT_FLAG
            }

            cardViewTodo.setOnClickListener {
                onClickInterface?.getTodoClicked(task)
            }


        }

    }
}