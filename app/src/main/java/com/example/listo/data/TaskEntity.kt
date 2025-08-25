package com.example.listo.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tasks")
data class TaskEntity(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val title: String,
    val description: String? = null,
    val bsYear: Int, // Bikram Sambat year
    val bsMonth: Int, // Bikram Sambat month
    val bsDay: Int, // Bikram Sambat day
    val isCompleted: Boolean = false,
    val isCreated: Long = System.currentTimeMillis(),
)