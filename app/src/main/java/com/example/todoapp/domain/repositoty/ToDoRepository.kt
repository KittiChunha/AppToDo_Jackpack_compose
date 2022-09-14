package com.example.todoapp.domain.repositoty

import com.example.todoapp.domain.model.ToDo
import kotlinx.coroutines.flow.Flow

interface ToDoRepository {
    suspend fun addToDo(toDo: ToDo)

    suspend fun deleteToDo(toDo: ToDo)

    suspend fun getToDoById(id: String): ToDo

    fun getToDos(): Flow<List<ToDo>>
}