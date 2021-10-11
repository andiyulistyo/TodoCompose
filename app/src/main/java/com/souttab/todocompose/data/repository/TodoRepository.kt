package com.souttab.todocompose.data.repository

import com.souttab.todocompose.data.TodoDao
import com.souttab.todocompose.data.models.ToDoTasks
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@ViewModelScoped
class TodoRepository @Inject constructor(private val todoDao: TodoDao) {

    val getAllTasks: Flow<List<ToDoTasks>> = todoDao.getAllTask()
    val sortByLowPriority: Flow<List<ToDoTasks>> = todoDao.sortByLowPriority()
    val sortByHighPriority: Flow<List<ToDoTasks>> = todoDao.sortByHighPriority()

    fun getSelectedTask(taskId: Int): Flow<ToDoTasks> {
        return todoDao.getSelectedTask(taskId)
    }

    suspend fun addTask(todoTasks: ToDoTasks) {
        todoDao.addTask(todoTasks)
    }

    suspend fun update(todoTasks: ToDoTasks) {
        todoDao.updateTask(todoTasks)
    }

    suspend fun delete(todoTasks: ToDoTasks) {
        todoDao.deleteTask(todoTasks)
    }

    suspend fun deleteAllTasks() {
        todoDao.deleteAllTasks()
    }

    fun searchDatabase(searchQuery: String): Flow<List<ToDoTasks>> {
        return todoDao.searchDatabase(searchQuery)
    }
}