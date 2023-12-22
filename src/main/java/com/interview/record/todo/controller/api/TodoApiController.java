package com.interview.record.todo.controller.api;

import com.interview.record.todo.dto.TodoReq;
import com.interview.record.todo.dto.TodoRes;
import com.interview.record.todo.dto.TodoStatusUpdateReq;
import com.interview.record.todo.service.TodoService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("/api/todo")
@RestController
public class TodoApiController {

    private final TodoService todoService;

    @PostMapping
    public ResponseEntity<Long> createTodo(@RequestBody TodoReq request) {
        Long id = todoService.todoCreate(request);
        return ResponseEntity.ok(id);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TodoRes> getTodo(@PathVariable("id") Long id) {
        TodoRes todo = todoService.getTodo(id);
        return ResponseEntity.ok(todo);
    }

    @GetMapping
    public ResponseEntity<List<TodoRes>> getTodos() {
        List<TodoRes> todoRes = todoService.todoList();
        return ResponseEntity.ok(todoRes);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateTodo(@PathVariable("id") Long id,
        @RequestBody TodoReq request) {
        todoService.updateTodo(id, request);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTodo(@PathVariable("id") Long id) {
        todoService.deleteTodo(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}/status")
    public ResponseEntity<?> updateTodoStatus(@PathVariable Long id,
        @RequestBody TodoStatusUpdateReq todoStatus) {
        todoService.updateTodoStatus(id, todoStatus.getTodoStatus());
        return ResponseEntity.ok().build();
    }

}
