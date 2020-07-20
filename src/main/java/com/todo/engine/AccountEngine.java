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
        String prompt = "Нажмите: \n \"1\" чтобы зарегистрироваться " +
                "\n \"2\" чтобы залогиниться" + "\n \"3\" чтобы удалить аккаунт";
        System.out.println(prompt);

        while (loopIsRunning) {
            account = getMainMenuOptions(scanner.nextInt());
        }
        return account;
    }

    private Account getMainMenuOptions(int option) {
        switch (option) {
            case 1:
                registration();
            case 2:
                return logIn();
            case 3:
                eliminateAcc();
            default:
                throw new UnsupportedOperationException(option + "not supported");
        }
    }

    private Account logIn() {
        Account account;
        System.out.println("Введите логин и пароль");
        System.out.println("Введите login");
        String login = scanner.next();
        System.out.println("Введите пароль");
        String password = scanner.next();

        try {
            account = accountService.get(login, password);
            loopIsRunning = false;
        } catch (NullPointerException ex) {
            loopIsRunning = false;
            throw ex;
        }
        return account;
    }

    private void registration() {
        System.out.println("Вы будете перенаправлены на регистрацию");
        System.out.println("Введите login");
        String login = scanner.next();
        System.out.println("Введите пароль");
        String password = scanner.next();
        accountService.create(login, password);
    }

    private void eliminateAcc() {
        Account accountToBeDeleted = null;
        System.out.println("Вы будете перенаправлены в меню удаления аккаунта");
        System.out.println("Введите login того аккаунта, который вы хотите удалить");
        String login = scanner.next();
        System.out.println("Введите пароль");
        String password = scanner.next();
        accountToBeDeleted = accountService.get(login, password);
        System.out.println("Аккаунт: " + accountToBeDeleted + " будет удален");
        accountService.delete(login, password);
        System.out.println("Удаление выполнено");
    }

    public void displayUserMenu(Account account) {
        loopIsRunning = true;
        while (loopIsRunning) {
            showMenuOptions();
            getUserMenuOptions(scanner.nextInt(), account);

        }
    }

    private void getUserMenuOptions(int userOptions, Account account) {
        String prompt = "Выберите задачу";
        System.out.println(prompt);
        if (userOptions >= 1 && userOptions <= 4) {
            switch (userOptions) {
                case 1:
                    createNewTask(account);
                    break;
                case 2:
                    showTaskAdded(account);
                    break;
                case 3:
                    eliminateTask(account);
                    break;
                case 4:
                    eliminateAcc();
                    break;
                case 5:
                    break;
            }
        }
    }

    private void showMenuOptions() {
        System.out.println("---Нажмите:---" + "" +
                "\n+ \"1\" - чтобы добавить Задачу" + "" +
                "\n+ \"2\" - чтобы показать Задачу" + "" +
                "\n+ \"3\" - чтобы удалить Задачу" + "" +
                "\n+ \"4\" - чтобы удалить Аккаунт" + "" +
                "\n+ \"5\" - чтобы выйти в подменю выше");
    }

    private void createNewTask(Account account) {
        System.out.println("Добавьте новое задание");
        String task = scanner.next();
        accountService.createTask(account, task);
    }

    private void showTaskAdded(Account account) {
        System.out.println(accountService.showTasks(account));
    }

    private void eliminateTask(Account account) {
        System.out.println("Введите задание, которое вы хотите удалить");
        String task = scanner.next();
        accountService.createTask(account, task);
    }

}