package com.todo.service;

import com.todo.domain.Account;
import com.todo.repository.AccountRepository;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {

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

    private final AccountRepository repository;

    public AccountServiceImpl(AccountRepository repository) {
        this.repository = repository;
    }
}
