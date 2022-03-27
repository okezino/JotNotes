package com.example.jotnote

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.jotnote.databinding.FragmentFirstBinding
import com.example.jotnote.databinding.FragmentSecondBinding
import com.example.jotnote.databinding.FragmentTodoBinding


class TodoFragment : Fragment() {
    private val args : TodoFragmentArgs by navArgs()
    private var _binding: FragmentTodoBinding? = null
    private val binding get() = _binding!!





    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentTodoBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.add_todo_menu, menu)

    }

}