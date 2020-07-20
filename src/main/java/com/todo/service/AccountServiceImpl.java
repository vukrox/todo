package com.todo.service;

import com.todo.domain.Account;
import com.todo.repository.AccountRepository;

import java.util.Map;
import java.util.Set;

public class AccountServiceImpl implements AccountService {

    private AccountRepository repository;

    public AccountServiceImpl(AccountRepository repository) {
        this.repository = repository;
    }

    @Override
    public Account create(String login, String password) {

        Account account = new Account(login, password);

        repository.add(account);

        return account;
    }

    @Override
    public Account get(String login, String password) {

        return repository.get(login, password);
    }

    @Override
    public void delete(String login, String password) {

        repository.remove(login, password);
    }

    @Override
    public void createTask(Account account, String task) {

        Set<Integer> idSet = account.getTasks().keySet();
        int finalIdOfTheSet = 0;
        for (int i = 0; i < idSet.size(); i++) {
            finalIdOfTheSet = i;
        }
        account.getTasks().put(finalIdOfTheSet, task);
        repository.update(account);
    }

    @Override
    public String getTask(Account account, int taskNumber) {

        return account.getTasks().get(taskNumber);
    }

    @Override
    public Map<Integer, String> showTasks(Account account) {
        return account.getTasks();
    }

    @Override
    public void removeTask(Account account, int taskNumber) {
        account.getTasks().remove(taskNumber);
        repository.update(account);
    }
}
