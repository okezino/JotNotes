package com.example.jotnote.ui.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.jotnote.data.Todo

class TodoListAdapter(private var todoClickInterface: TodoClickInterface) : RecyclerView.Adapter<TodoListViewHolder>() {

    var dataList = mutableListOf<Todo>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoListViewHolder {
           val view = TodoListViewHolder.apply {
               onClickInterface = todoClickInterface
           }
          return view.from(parent)
    }

    override fun onBindViewHolder(holder: TodoListViewHolder, position: Int) {
        holder.bind(dataList[position])
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

}