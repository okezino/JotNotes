package com.example.jotnote

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.jotnote.data.Task
import com.example.jotnote.data.Todo
import com.example.jotnote.databinding.FragmentTodoBinding
import com.example.jotnote.ui.viewmodel.TodoListViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TodoFragment : Fragment() {
    private val args : TodoFragmentArgs by navArgs()
    private var _binding: FragmentTodoBinding? = null
    private val binding get() = _binding!!
    private val todoListViewModel : TodoListViewModel by activityViewModels()


    var todoTitle : String? = null
    var todoDescription : String? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentTodoBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        activateWatchersAndListeners()
    }



    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.add_todo_menu, menu)

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when(item.itemId){
            R.id.action_done -> {
                if(validateTask()){
                    val todo1 = Todo(title = todoTitle!!,status = false, type = getTaskType(args.todoType),description = todoDescription!!, time = "12:00PM", date = "19/09/2009")
                    todoListViewModel.insertTodo(todo1)
                    findNavController().navigate(R.id.JotNote)

                } else Toast.makeText(context, "Empty Todo",Toast.LENGTH_LONG).show()
            }
            R.id.action_undo -> {}
            R.id.action_redo -> {}
        }

        return super.onOptionsItemSelected(item)
    }

    private fun activateWatchersAndListeners(){
        titleTextWatcher()
        descriptionTextWatcher()
    }

    private fun titleTextWatcher(){
        binding.taskTitle.addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                todoTitle = p0.toString()
            }

            override fun afterTextChanged(p0: Editable?) {
                todoTitle = p0.toString()
            }

        })
    }

    private fun descriptionTextWatcher(){
        binding.taskDescription.addTextChangedListener(object :TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                todoDescription = p0.toString()
            }

            override fun afterTextChanged(p0: Editable?) {
                todoDescription = p0.toString()
            }

        })
    }

    private fun validateTask() : Boolean{
        return !(todoTitle == null || todoDescription == null)
    }

    private fun getTaskType(type : String) : Task{
        return when(type){
            "Note" -> Task.NOTE
            else -> Task.TODO
        }
    }

}