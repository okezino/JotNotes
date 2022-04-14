package com.example.jotnote.presentation.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.jotnote.data.TaskData

class TaskListAdapter(private var taskClickInterface: TaskClickInterface) : RecyclerView.Adapter<TaskListViewHolder>() {

    var dataList = mutableListOf<TaskData>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskListViewHolder {
           val view = TaskListViewHolder.apply {
               onClickInterface = taskClickInterface
           }
          return view.from(parent)
    }

    override fun onBindViewHolder(holder: TaskListViewHolder, position: Int) {
        holder.bind(dataList[position])
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

}