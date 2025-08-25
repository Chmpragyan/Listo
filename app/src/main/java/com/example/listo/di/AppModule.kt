package com.example.listo.di

import android.app.Application
import androidx.room.Room
import com.example.listo.data.TaskDao
import com.example.listo.data.TaskDatabase
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
    fun provideDatabase(app: Application): TaskDatabase {
        return Room.databaseBuilder(
            app,
            TaskDatabase::class.java,
            "task_db"
        ).build()
    }

    @Provides
    fun provideDao(db: TaskDatabase): TaskDao = db.taskDao()
}