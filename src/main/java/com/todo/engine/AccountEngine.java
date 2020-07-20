package com.todo.engine;

import com.todo.domain.Account;
import com.todo.service.AccountService;

import java.util.Scanner;

public class AccountEngine {

    private final AccountService accountService;

    private boolean loopIsRunning = true;

    private final Scanner scanner;

    public AccountEngine(AccountService accountService) {
        this.accountService = accountService;
        this.scanner = new Scanner(System.in);
    }

    public Account displayMainMenu() {

        Account account = null;
        String prompt = "Нажмите: \n \"1\" чтобы зарегистрироваться, или \n \"2\" чтобы залогиниться.";
        System.out.println(prompt);

        while (loopIsRunning) {
            account = getMainMenuOptions(scanner.nextInt());
        }
        return account;
    }

    private Account getMainMenuOptions(int option) {
        switch (option) {
            case 1:
                registration(scanner);
            case 2:
                return logIn(scanner);
            default:
                throw new UnsupportedOperationException(option + "not supported");
        }
    }

    private Account logIn(Scanner scanner) {

        System.out.println("Введите логин и пароль");
        System.out.println("Введите login");
        String login = scanner.next();
        System.out.println("Введите пароль");
        String password = scanner.next();

        try {
        return accountService.get(login, password);
        } catch (NullPointerException ex) {
            loopIsRunning = false;
            throw ex;
        }
    }

    private void registration(Scanner scanner) {
        System.out.println("Вы будете перенаправлены на регистрацию");
        System.out.println("Введите login");
        String login = scanner.next();
        System.out.println("Введите пароль");
        String password = scanner.next();
        accountService.create(login, password);
    }

    public void displayUserMenu(Account account) {
        loopIsRunning = true;
        while (loopIsRunning) {
            getUserMenuOptions (scanner.nextInt(), account);
        }

    }

    private void getUserMenuOptions(int userOptions, Account account) {
        showMenuOptions();
        String prompt = "Выберите задачу";
        System.out.println(prompt);
        if (userOptions >= 1 && userOptions <= 4) {
            switch (userOptions) {
                case 1:
                    createNewTask(account);
                    break;
                case 2:

            }
        }
    }

    private void showMenuOptions() {
        System.out.println("---Нажмите:---" + "" +
                "\n+ \"1\" - чтобы добавить Задачу" + "" +
                "\n+ \"2\" - чтобы показать Задачу" + "" +
                "\n+ \"3\" - чтобы удалить Задачу" + "" +
                "\n+ \"4\" - чтобы удалить Аккаунт");
    }

    private void createNewTask(Account account) {
        System.out.println("Добавьте новое задание");
        String task = scanner.next();
        accountService.createTask(account, task);
    }

    private void showTaskAdded(Account account) {
        accountService.showTasks(account);
    }

}
