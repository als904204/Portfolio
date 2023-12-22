package com.interview.record.todo.dto;

import com.interview.record.todo.entity.Todo;
import com.interview.record.todo.entity.TodoStatus;
import lombok.Getter;

@Getter
public class TodoResponse {


    private final Long id;
    private final String title;
    private final String content;
    private final TodoStatus todoStatus;
    private final boolean completed;


    public TodoResponse(Todo todo) {
        this.id = todo.getId();
        this.title = todo.getTitle();
        this.content = todo.getContent();
        this.todoStatus = todo.getTodoStatus();
        this.completed = todo.isCompleted();

    }



}
