package com.interview.record.todo.dto;

import lombok.Getter;

@Getter
public class TodoReq {

    private String title;
    private String content;
    private boolean completed;


}