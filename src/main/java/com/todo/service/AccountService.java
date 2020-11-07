package com.todo.service;

import com.todo.domain.Account;

import java.util.Map;

public interface AccountService {
    Account create(String login, String password);

    Account get(String login);

    void delete(String login);

}
