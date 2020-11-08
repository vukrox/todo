package com.todo.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

//todo TaskRepo + connect JPA with custom QUERY, TaskService methods: findFirst, findLast, findByAccount;

@Data
@Entity
@Table(name = "task")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String taskName;
    private Date startTask;
    private Date endTask;
    private Date creationTaskDate;
    private boolean isCompleted;
    @OneToOne(mappedBy = "task")
    private Account account;
}