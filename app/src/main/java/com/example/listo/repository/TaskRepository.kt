package com.example.listo.repository

import com.example.listo.data.TaskDao
import com.example.listo.data.TaskEntity
import jakarta.inject.Inject

class TaskRepository @Inject constructor(private val taskDao: TaskDao) {
    suspend fun insertTask(task: TaskEntity) {
        taskDao.insertTask(task)
    }

    fun getTasksByDate(year: Int, month: Int, day: Int) = taskDao.getTasksByDate(year, month, day)

    fun getAllTasks() = taskDao.getAllTasks()

    suspend fun updateTask(task: TaskEntity) {
        taskDao.updateTask(task)
    }

    suspend fun deleteTask(task: TaskEntity) = taskDao.deleteTask(task)
}