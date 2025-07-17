package com.example.todo.todo.feature.todo

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.time.LocalDateTime
import java.util.UUID

@Entity
@Table(name = "todos")
data class Todos(
    @Id @GeneratedValue(strategy = GenerationType.UUID) val id: UUID,

    @Column(nullable = false) var task: String,

    @Enumerated(EnumType.STRING) var status: TaskStatus,

    @Column var isCompleted: Boolean = false,

    @Column val creationDate: LocalDateTime = LocalDateTime.now(),
)
