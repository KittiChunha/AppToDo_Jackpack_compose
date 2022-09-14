package com.example.todoapp.di

import android.app.Application
import androidx.room.Room
import com.example.todoapp.data.data_source.ToDoDatabase
import com.example.todoapp.data.repository.ToDoRepositoryImpl
import com.example.todoapp.domain.repositoty.ToDoRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideToDoDatabase(app: Application): ToDoDatabase {
        return Room.databaseBuilder(
            app,
            ToDoDatabase::class.java,
            "todo_db"
        ).build()
    }

    @Provides
    @Singleton
    fun provideToDoRepository(db: ToDoDatabase): ToDoRepository {
        return ToDoRepositoryImpl(db.dao)
    }
}