package com.example.jotnote.ui

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.jotnote.R
import com.example.jotnote.databinding.FragmentFirstBinding

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class JotNote : Fragment() {

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
            navigateToAddTodoScreen()
        }
        binding.addTodo.setOnClickListener {
            navigateToAddTodoScreen("To-do")
        }

        binding.addNote.setOnClickListener {
            navigateToAddTodoScreen()
        }
    }

    private fun navigateToAddTodoScreen(title : String = "Note"){
        val action = JotNoteDirections.actionJotNoteToTodoFragment(title)
        findNavController().navigate(action)
    }
}