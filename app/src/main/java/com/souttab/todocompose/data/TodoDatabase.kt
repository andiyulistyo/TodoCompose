package com.souttab.todocompose.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.souttab.todocompose.data.models.ToDoTasks

@Database(entities = [ToDoTasks::class], version = 1, exportSchema = false)
abstract class TodoDatabase : RoomDatabase(){

    abstract fun todoDao(): TodoDao
}