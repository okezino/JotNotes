package com.example.jotnote.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.example.jotnote.domain.RepositoryInterface
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class TodoListViewModel @Inject constructor(
    val repository: RepositoryInterface
) : ViewModel() {
}