package com.todo.domain;

import lombok.Data;

import java.util.Date;
import java.util.UUID;

//todo TaskRepo + connect JPA with custom QUERY, TaskService methods: findFirst, findLast, findByAccount;

@Data
public class Task {
    private UUID id;
    private String taskName;
    private Date startTask;
    private Date endTask;
    private boolean isCompleted;
}