package com.example.todoapp.data.repository

import com.example.todoapp.data.data_source.ToDoDao
import com.example.todoapp.domain.model.ToDo
import com.example.todoapp.domain.repositoty.ToDoRepository
import kotlinx.coroutines.flow.Flow

class ToDoRepositoryImpl(
    private val dao: ToDoDao
): ToDoRepository {
    override suspend fun addToDo(toDo: ToDo) {
        dao.addToDo(toDo)
    }

    override suspend fun deleteToDo(toDo: ToDo) {
        dao.deleteToDo(toDo)
    }

    override suspend fun getToDoById(id: String): ToDo {
        return dao.getToDoById(id)
    }

    override fun getToDos(): Flow<List<ToDo>> {
        return dao.getToDos()
    }
}