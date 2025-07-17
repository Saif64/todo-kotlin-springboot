package com.example.todo.todo.feature.todo

import jakarta.transaction.Transactional
import org.springframework.stereotype.Service
import java.util.UUID

@Service
class TodoService(private val todoRepository: TodoRepository) {
    @Transactional
    fun getAllTodos(): List<Todos> {
        return todoRepository.findAll()
    }

    fun createTodos(newTodo: Todos): Todos {
        if (newTodo.task.isBlank()) throw IllegalArgumentException("Task can not be blank")

        val todo = todoRepository.save(newTodo)

        return todo;
    }

    fun getTodosById(id: UUID): Todos? {
        return todoRepository.findById(id).orElse(null)
    }

    fun updateStatus(id: UUID, updatedTodo: Todos): Todos? {
        val todo: Todos? = getTodosById(id)

        return todo?.also { existingTodo ->

            existingTodo.task = updatedTodo.task
            existingTodo.status = updatedTodo.status

            if (existingTodo.status == TaskStatus.DONE) existingTodo.isCompleted = true

            todoRepository.update(existingTodo)
        }
    }
}
