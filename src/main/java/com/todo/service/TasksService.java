package com.todo.service;

import com.todo.domain.Account;

import java.util.Map;

public interface TasksService {

    void createTask(Account account, String task);

    String getTask(Account account, int taskNumber);

    Map<Integer, String> showTasks(Account account);

    void removeTask(Account account, int taskNumber);
}
