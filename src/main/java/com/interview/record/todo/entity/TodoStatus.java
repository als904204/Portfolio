package com.interview.record.todo.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum TodoStatus {
    SUCCESS("SUCCESS"),
    TRYING("TRYING"),
    FAIL("FAIL");
    private final String key;
}

