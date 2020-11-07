package com.todo.service;

import com.todo.domain.Account;
import com.todo.domain.Task;
import com.todo.repository.AccountRepository;
import com.todo.repository.TaskRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Map;

@Slf4j
@Service
public class TaskServiceImp implements TasksService {

    private final AccountRepository accountRepository;
    private final TaskRepository taskRepository;

    public TaskServiceImp(TaskRepository taskRepository, AccountRepository accountRepository) {
        this.taskRepository = taskRepository;
        this.accountRepository = accountRepository;
    }

    @Override
    public Task getFirstTask(String login) {
        Account account = accountRepository.findByLogin(login);


        return null;
    }

    @Override
    public Task getLastTask(Account account) {
        return null;
    }

    @Override
    public void createTask(Account account, String task) {

    }

    @Override
    public String getTask(Account account, int taskNumber) {
        return null;
    }

    @Override
    public Map<Integer, String> showTasks(Account account) {
        return null;
    }

    @Override
    public void removeTask(Account account, int taskNumber) {

    }
}
