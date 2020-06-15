package com.todo.service;

import com.todo.domain.Account;
import com.todo.repository.AccountRepository;

import java.util.Map;

public class AccountServiceImpl implements AccountService {

    private AccountRepository repository;

    public AccountServiceImpl(AccountRepository repository) {
        this.repository = repository;
    }

    @Override
    public Account create(String login, String password) {
        return null;
    }

    @Override
    public Account get(String login, String password) {
        return null;
    }

    @Override
    public void delete(String login, String password) {

    }

    @Override
    public void createTask(Account account, String task) {

    }

    @Override
    public void getTask(Account account, int taskNumber) {

    }

    @Override
    public Map<Integer, String> showTasks(Account account) {
        return null;
    }

    @Override
    public void removeTask(Account account, int taskNumber) {

    }
}
