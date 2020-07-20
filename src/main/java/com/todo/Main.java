package com.todo;

import com.todo.domain.Account;
import com.todo.engine.AccountEngine;
import com.todo.repository.AccountRepository;
import com.todo.repository.AccountRepositoryFileStorage;
import com.todo.service.AccountService;
import com.todo.service.AccountServiceImpl;

public class Main {
    public static void main(String[] args) {
        AccountRepository repository = new AccountRepositoryFileStorage();

        AccountService service = new AccountServiceImpl(repository);

        AccountEngine engine = new AccountEngine(service);

        Account account = engine.displayMainMenu();

        System.out.println("start UserMenu");

        engine.displayUserMenu(account);

    }
}
