package com.interview.record.todo.entity;

import com.interview.record.global.Auditable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.time.LocalDateTime;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;


@NoArgsConstructor
@Getter
@Entity
public class Todo extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String title;

    private boolean completed;

    @Builder
    public Todo(String title, boolean completed) {
        this.title = title;
        this.completed = completed;
    }

    public void update(String title, boolean completed) {
        this.title = title;
        this.completed = completed;
    }

}
