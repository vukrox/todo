package com.todo;

import com.todo.domain.Account;
import com.todo.repository.AccountRepository;
import com.todo.repository.AccountRepositoryFileStorage;

public class Main {
    public static void main(String[] args) {
        AccountRepository repository = new AccountRepositoryFileStorage();
//        AccountService service = new AccountServiceImpl(repository);
//        AccountEngine engine = new AccountEngine(service);
//        engine.displayMainMenu();
//        engine.displayUserMenu();
        System.out.println(repository.get("test", "test"));

        System.out.println(repository.get("test", "test1"));

        System.out.println(repository.get("test1", "test"));


    }
}
