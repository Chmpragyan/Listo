package com.example.listo.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.listo.data.TaskEntity
import com.example.listo.repository.TaskRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TaskViewModel @Inject constructor(private val taskRepository: TaskRepository) : ViewModel() {
    private val _todayTasks = MutableStateFlow<List<TaskEntity>>(emptyList())
    val todayTasks: StateFlow<List<TaskEntity>> = _todayTasks

    fun loadTasksForDate(year: Int, month: Int, day: Int) {
        viewModelScope.launch {
            taskRepository.getTasksByDate(year, month, day).collect { tasks ->
                _todayTasks.value = tasks
            }
        }
    }

    fun addTask(taskEntity: TaskEntity) {
        viewModelScope.launch {
            taskRepository.insertTask(taskEntity)
        }
    }

    fun toggleComplete(taskEntity: TaskEntity) {
        viewModelScope.launch {
            taskRepository.updateTask(taskEntity.copy(isCompleted = !taskEntity.isCompleted))
        }
    }
}