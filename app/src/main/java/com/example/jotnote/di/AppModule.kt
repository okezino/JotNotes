package com.example.jotnote.di

import android.app.Application
import androidx.room.Room
import com.example.jotnote.data.TodoDataBase
import com.example.jotnote.domain.RepositoryInterface
import com.example.jotnote.data.TodoRepositoryImpl
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



            /**
             * @Synchronisedlock
             *When a thread calls Synchronised Lock, it acquires the lock of the scynchrozied block
             * other threads dont have permission to call that same sycnchronised block as long as the
             * previous thread which had aquired the synchronised lock does not release the lock.
             *
             * NOTE:If the synchrozied block is not there, multiple thread can be creating different instances
             */

            synchronized(this){
                val instance = Room.databaseBuilder(
                    app,
                    TodoDataBase::class.java,
                    "todo_db"
                ).build()

                return instance
            }

        }


    @Provides
    @Singleton
    fun provideTodoRepository(db : TodoDataBase): RepositoryInterface{
        return TodoRepositoryImpl(db.dao)
    }
}