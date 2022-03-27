package com.example.jotnote.ui

import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.jotnote.R
import com.example.jotnote.data.Todo
import com.example.jotnote.data.allTodo
import com.example.jotnote.databinding.FragmentFirstBinding
import com.example.jotnote.ui.adapter.TodoClickInterface
import com.example.jotnote.ui.adapter.TodoListAdapter


class JotNote : Fragment(),TodoClickInterface {

    private var _binding: FragmentFirstBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        activateClickListeners()
        launchHomeView()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }



    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.menu_main, menu)

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun setNotesTodoBtnVisibility(){
        with(binding){
            addNoteText.visibility =  View.VISIBLE
            addNote.visibility = View.VISIBLE
            addTodo.visibility = View.VISIBLE
            addTodoText.visibility = View.VISIBLE
            addGeneralBtn.visibility = View.GONE
            cancelBtn.visibility = View.VISIBLE
        }
    }

    private fun disableNotesTodoBtnVisibility(){
        with(binding){
            addTodoText.visibility =  View.GONE
            addTodo.visibility = View.GONE
            addNoteText.visibility = View.GONE
            addNote.visibility = View.GONE
            addGeneralBtn.visibility = View.VISIBLE
            cancelBtn.visibility = View.GONE
        }
    }

    private fun setAddNotesTodoListener(){
        binding.addGeneralBtn.setOnClickListener {
            setNotesTodoBtnVisibility()
        }
    }

    private fun setCancelBtnListener(){
        binding.cancelBtn.setOnClickListener {
            disableNotesTodoBtnVisibility()
        }
    }

    private fun activateClickListeners(){
        addTodoClickListener()
        setAddNotesTodoListener()
        setCancelBtnListener()
    }

    private fun addTodoClickListener(){
        binding.addTodoBtn.setOnClickListener {
            navigateToAddNoteScreen()
        }
        binding.addTodo.setOnClickListener {
            navigateToAddTodoScreen()
        }

        binding.addNote.setOnClickListener {
            navigateToAddNoteScreen()
        }
    }

    private fun navigateToAddTodoScreen(title : String = "Todo"){
        findNavController().findDestination(R.id.todoFragment)?.label = "To-do"
        val action = JotNoteDirections.actionJotNoteToTodoFragment(title)
        findNavController().navigate(action)
    }
    private fun navigateToAddNoteScreen(title : String = "Note"){
        findNavController().findDestination(R.id.todoFragment)?.label = "Notes "
        val action = JotNoteDirections.actionJotNoteToTodoFragment(title)
        findNavController().navigate(action)
    }

    private fun showEmptyTodoScreen(){
        with(binding){
            welcomeImage.isVisible = true
            emptyTodo.isVisible = true
            addTodoBtn.isVisible = true
        }
    }

    private fun validateTodos():Boolean{
        return allTodo.size == 0
    }

    private fun showAllTodos(){
        var newAdapter = TodoListAdapter(this).apply {
            dataList = allTodo
        }
        with(binding.todoRecyclerview){
         layoutManager = LinearLayoutManager(context)
           adapter = newAdapter
        }

    }


    private fun launchHomeView(){
        if(validateTodos()) showEmptyTodoScreen() else showAllTodos()
    }

    override fun getTodoClicked(todo: Todo) {
       Toast.makeText(context,"wow",Toast.LENGTH_LONG).show()
    }
}