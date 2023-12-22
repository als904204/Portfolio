package com.interview.record.todo.service;

import com.interview.record.todo.dto.TodoResponse;
import com.interview.record.todo.dto.TodoReq;
import com.interview.record.todo.dto.TodoRes;
import com.interview.record.todo.entity.Todo;
import com.interview.record.todo.entity.TodoStatus;
import com.interview.record.todo.repository.TodoRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
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
            .content(todoReq.getContent())
            .todoStatus(TodoStatus.TRYING)
            .completed(todoReq.isCompleted())
            .build();
        Todo savedTodo = todoRepository.save(todo);
        return savedTodo.getId();
    }

    @Transactional(readOnly = true)
    public List<TodoRes> todoList() {
        return todoRepository.findAll(Sort.by(Sort.Direction.DESC, "createdAt"))
            .stream()
            .map(t -> new TodoRes(
                t.getId(),
                t.getTitle(),
                t.getContent(),
                t.getTodoStatus(),
                t.isCompleted(),
                t.getCreatedAt()))
            .toList();
    }

    @Transactional(readOnly = true)
    public TodoRes getTodo(Long id) {
        Todo todo = todoRepository.findById(id).orElseThrow(() -> new IllegalArgumentException(
            "Todo not found"));
        return new TodoRes(todo.getId(), todo.getTitle(), todo.getContent(),todo.getTodoStatus(),todo.isCompleted(), todo.getCreatedAt());
    }

    @Transactional
    public void updateTodo(Long id, TodoReq todoReq) {
        Todo todo = todoRepository.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("Todo not found"));
        todo.updateTodo(todoReq.getTitle(), todoReq.getContent(), todoReq.isCompleted());
    }

    @Transactional
    public void deleteTodo(Long id) {
        Todo todo = todoRepository.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("Todo not found"));
        todoRepository.delete(todo);
    }

    @Transactional
    public void updateTodoStatus(Long id, TodoStatus status) {
        Todo todo = todoRepository.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("Todo not found"));
        todo.updateTodoStatus(status);
        todoRepository.save(todo);
    }



    public List<TodoResponse> getAllTodos() {
        List<Todo> all = todoRepository.findAll();
        return all.stream()
            .map(TodoResponse::new)
            .toList();
    }


}
