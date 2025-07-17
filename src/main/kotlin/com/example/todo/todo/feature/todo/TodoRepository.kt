package com.example.todo.todo.feature.todo

import com.example.todo.todo.TodoApplication
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
interface TodoRepository : JpaRepository<Todos, UUID> {
    fun getTodosByStatus(status: TaskStatus) : List<Todos>
    fun update(todo: Todos): Todos
}