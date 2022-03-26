package com.example.jotnote.di

import android.app.Application
import androidx.room.Room
import com.example.jotnote.data.TodoDataBase
import com.example.jotnote.domain.RepositoryInterface
import com.example.jotnote.domain.TodoRepositoryImpl
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
    fun provideTodoDataBase(app: Application) : TodoDataBase{

        return Room.databaseBuilder(app,TodoDataBase::class.java, "todo_db")
            .build()
    }

    @Provides
    @Singleton
    fun provideTodoRepository(db : TodoDataBase): RepositoryInterface{
        return TodoRepositoryImpl(db.dao)
    }
}