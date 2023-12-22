package com.interview.record.todo.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.interview.record.todo.entity.TodoStatus;
import java.time.LocalDateTime;
import lombok.Getter;

@Getter
public class TodoRes {

    private final Long id;
    private final String title;
    private final String content;
    private final String todoStatus;


    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "MM.dd HH:mm")
    private final LocalDateTime createdAt;

    public TodoRes(Long id, String title, String content, TodoStatus todoStatus,
        LocalDateTime createdAt) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.todoStatus = todoStatus.getKey();
        this.createdAt = createdAt;
    }


}
