package com.example.todo.todo.feature.todo

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/todos")
class TodoController(private val todoService: TodoService) {
    @GetMapping
    fun getTodos(): ResponseEntity<List<TodoDto>> {
        val todos = todoService.getAllTodos()

        return ResponseEntity.ok(todos.map { todos ->
            TodoDto(
                id = todos.id, task = todos.task, status = todos.status, isCompleted = todos.isCompleted
            )
        })
    }

    @PostMapping
    fun createTodo(@RequestBody todo: Todos): ResponseEntity<TodoDto> {
        val newTodo = todoService.createTodos(todo)

        return ResponseEntity.status(HttpStatus.CREATED).body(
            TodoDto(
                id = newTodo.id,
                task = newTodo.task,
                status = newTodo.status,
                isCompleted = false,
            )
        )
    }

}