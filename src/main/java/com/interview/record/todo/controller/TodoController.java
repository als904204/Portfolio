package com.interview.record.todo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/todo")
@Controller
public class TodoController {

    @GetMapping
    public String todo() {
        return "/todo";
    }

    @GetMapping("/form")
    public String todoForm() {
        return "/todo-form";
    }
}
