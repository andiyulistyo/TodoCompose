package com.souttab.todocompose.ui.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.souttab.todocompose.data.models.ToDoTasks
import com.souttab.todocompose.data.repository.TodoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ShareViewModel @Inject constructor(private val repository: TodoRepository) : ViewModel() {

    private val _allTasks = MutableStateFlow<List<ToDoTasks>>(emptyList())
    val allTasks : StateFlow<List<ToDoTasks>> = _allTasks

    fun getAllTask() {
        viewModelScope.launch {
            repository.getAllTasks.collect {
                _allTasks.value = it
            }
        }
    }
}