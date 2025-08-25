package com.example.listo.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface TaskDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTask(taskEntity: TaskEntity)

    @Query("SELECT * FROM tasks WHERE bsYear = :year AND bsMonth = :month AND bsDay = :day ORDER BY isCompleted")
    suspend fun getTasksByDate(year: Int, month: Int, day: Int): Flow<List<TaskEntity>>

    @Query("SELECT * FROM tasks ORDER BY bsYear, bsMonth, bsDay ASC")
    suspend fun getAllTasks(): Flow<List<TaskEntity>>

    @Update
    suspend fun updateTask(taskEntity: TaskEntity)

    @Delete
    suspend fun deleteTask(taskEntity: TaskEntity)
}