package com.souttab.todocompose.data

import androidx.room.*
import com.souttab.todocompose.data.models.ToDoTasks
import kotlinx.coroutines.flow.Flow

@Dao
interface TodoDao {

    @Query("SELECT * FROM todo_table ORDER BY id ASC")
    fun getAllTask(): Flow<List<ToDoTasks>>

    @Query("SELECT * FROM todo_table WHERE id=:taskId")
    fun getSelectedTask(taskId: Int): Flow<ToDoTasks>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addTask(toDoTasks: ToDoTasks)

    @Update
    suspend fun updateTask(toDoTasks: ToDoTasks)

    @Delete
    suspend fun deleteTask(toDoTasks: ToDoTasks)

    @Query("DELETE FROM todo_table")
    suspend fun deleteAllTasks()

    @Query("SELECT * FROM todo_table WHERE title LIKE " +
            ":searchQuery OR description LIKE " +
            ":searchQuery ORDER BY id ASC")
    fun searchDatabase(searchQuery: String): Flow<List<ToDoTasks>>

    @Query("SELECT * FROM todo_table" +
            "ORDER BY CASE WHEN priority LIKE 'L%' THEN 1" +
            "WHEN priority LIKE 'M%' THEN 2" +
            "WHEN priority LIKE 'H%' THEN 3 END")
    fun sortByLowPriority(): Flow<List<ToDoTasks>>

    @Query("SELECT * FROM todo_table" +
            "ORDER BY CASE WHEN priority LIKE 'H%' THEN 1" +
            "WHEN priority LIKE 'M%' THEN 2" +
            "WHEN priority LIKE 'L%' THEN 3 END")
    fun sortByHighPriority(): Flow<List<ToDoTasks>>
}