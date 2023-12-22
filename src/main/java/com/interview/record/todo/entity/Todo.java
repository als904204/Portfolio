package com.interview.record.todo.entity;

import com.interview.record.global.Auditable;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@Getter
@Entity
public class Todo extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String content;

    @Enumerated(EnumType.STRING)
    private TodoStatus todoStatus;


    @Builder
    public Todo(String title, String content,TodoStatus todoStatus) {
        this.title = title;
        this.content = content;
        this.todoStatus = todoStatus;
    }

    public void updateTodo(String title,String content) {
        this.title = title;
        this.content = content;
    }

    public void updateTodoStatus(TodoStatus todoStatus) {
        this.todoStatus = todoStatus;
    }
}
