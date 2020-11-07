package com.todo.service;

import com.todo.domain.Account;
import com.todo.domain.Task;

import java.util.Date;
import java.util.Map;

public interface TasksService {

    void createTask(Account account, String task);

    String getTask(Account account, int taskNumber);

    Task getFirstTask(String login);

    Task getLastTask(Account account);

    Map<Integer, String> showTasks(Account account);

    void removeTask(Account account, int taskNumber);
}
