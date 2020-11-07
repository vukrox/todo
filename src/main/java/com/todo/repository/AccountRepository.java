package com.todo.repository;

import com.todo.domain.Account;

public interface AccountRepository extends  {

    void add(Account account);
    Account get(String login, String password);
    void update(Account account);
    void remove(String login, String password);
}
