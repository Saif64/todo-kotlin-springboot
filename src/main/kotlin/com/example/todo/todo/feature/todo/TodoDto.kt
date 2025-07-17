package com.example.todo.todo.feature.todo

import java.util.UUID

// For responses (what you send back to the client)
data class TodoDto(
    val id: UUID,
    val task: String,
    val status: TaskStatus,
    val isCompleted: Boolean
)

// For requests (what the client sends to create/update a todo)
// You might omit 'id' and 'isCompleted' for creation, and 'id' for update
data class CreateTodoRequest(
    val task: String,
    val status: TaskStatus // You might default this in your service
)

data class UpdateTodoRequest(
    val task: String?, // Make optional if only some fields can be updated
    val status: TaskStatus?
)