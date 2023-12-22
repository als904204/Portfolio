package com.interview.record.todo.entity;

import com.interview.record.global.Auditable;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@Getter
@Entity
public class Todo extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String title;

    private String content;

    @Enumerated(EnumType.STRING)
    private TodoStatus todoStatus;

    private boolean completed;


    @Builder
    public Todo(String title, String content,TodoStatus todoStatus,boolean completed) {
        this.title = title;
        this.content = content;
        this.todoStatus = todoStatus;
        this.completed = completed;
    }

    public void updateTodo(String title,String content, boolean completed) {
        this.title = title;
        this.content = content;
        this.completed = completed;
    }

    public void updateTodoStatus(TodoStatus todoStatus) {
        this.todoStatus = todoStatus;
    }
}
