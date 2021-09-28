package com.souttab.todocompose.data

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.souttab.todocompose.util.Constants.DATABASE_TABLE

@Entity(tableName = DATABASE_TABLE)
data class ToDoTasks(
    @PrimaryKey(autoGenerate = true)
    val id : Int = 0,
    val title : String,
    val description : String,
    val priority: Priority
)