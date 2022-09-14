package com.example.todoapp.data.data_source

import androidx.room.*
import com.example.todoapp.domain.model.ToDo
import kotlinx.coroutines.flow.Flow

@Dao
interface ToDoDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addToDo(toDo: ToDo)

    @Delete
    suspend fun deleteToDo(toDo: ToDo)

    @Query("select * from todo where id = :id")
    suspend fun getToDoById(id: String): ToDo

    @Query("select * from todo order by id")
    fun getToDos(): Flow<List<ToDo>>
}