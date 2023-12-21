package com.interview.record.todo.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDateTime;
import lombok.Getter;

@Getter
public class TodoRes {

    private final Long id;
    private final String title;
    private final boolean completed;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "MM.dd HH:mm")
    private final LocalDateTime createdAt;

    public TodoRes(Long id, String title, boolean completed, LocalDateTime createdAt) {
        this.id = id;
        this.title = title;
        this.completed = completed;
        this.createdAt = createdAt;
    }


}
