package com.example.listo.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tasks")
data class TaskEntity(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val title: String,
    val description: String? = null,
    val bsYear: Int, // bs(Bikram Sambat)
    val bsMonth: Int,
    val bsDay: Int,
    val isCompleted: Boolean = false,
    val isCreated: Long = System.currentTimeMillis(),
)