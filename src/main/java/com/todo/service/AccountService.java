package com.todo.service;

import com.todo.domain.Account;

import java.util.Map;

public interface AccountService {
    Account create(String login, String password);

    Account get(String login, String password);

    void delete(String login, String password);

    void createTask(Account account, String task);

    void getTask(Account account, int taskNumber);

    Map<Integer, String> showTasks(Account account);

    void removeTask(Account account, int taskNumber);
}
