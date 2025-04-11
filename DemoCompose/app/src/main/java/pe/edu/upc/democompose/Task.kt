package pe.edu.upc.democompose

import java.util.Date

data class Task(
    val title: String,
    val createdAt: Date,
    val dueDate: Date,
    var isCompleted: Boolean
)
