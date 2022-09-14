package com.example.todoapp.data.data_source

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.todoapp.domain.model.ToDo
import com.example.todoapp.domain.util.UUIDToString

@Database(entities = [ToDo::class], version = 1, exportSchema = false)
@TypeConverters(UUIDToString::class)
abstract class ToDoDatabase: RoomDatabase() {
    abstract val dao: ToDoDao
}