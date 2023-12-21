package com.interview.record.todo.service;

import com.interview.record.todo.dto.TodoReq;
import com.interview.record.todo.dto.TodoRes;
import com.interview.record.todo.entity.Todo;
import com.interview.record.todo.repository.TodoRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class TodoService {

    private final TodoRepository todoRepository;


    @Transactional
    public Long todoCreate(TodoReq todoReq) {
        Todo todo = Todo.builder()
            .title(todoReq.getTitle())
            .completed(todoReq.isCompleted())
            .build();
        Todo savedTodo = todoRepository.save(todo);
        return savedTodo.getId();
    }

    @Transactional(readOnly = true)
    public List<TodoRes> todoList() {
        return todoRepository.findAll()
            .stream()
            .map(t -> new TodoRes(
                t.getId(),
                t.getTitle(),
                t.isCompleted(),
                t.getCreatedAt()))
            .toList();
    }

    @Transactional(readOnly = true)
    public TodoRes getTodo(Long id) {
        Todo todo = todoRepository.findById(id).orElseThrow(() -> new IllegalArgumentException(
            "can't find todo"));
        return new TodoRes(todo.getId(), todo.getTitle(), todo.isCompleted(), todo.getCreatedAt());
    }

    @Transactional
    public void updateTodo(Long id, TodoReq todoReq) {
        Todo todo = todoRepository.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("can't find todo"));
        todo.update(todoReq.getTitle(), todoReq.isCompleted());
    }

    @Transactional
    public void deleteTodo(Long id) {
        Todo todo = todoRepository.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("can't find todo"));
        todoRepository.delete(todo);
    }



}