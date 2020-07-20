package com.todo.engine;

import com.todo.domain.Account;
import com.todo.service.AccountService;

import java.util.Scanner;

public class AccountEngine {

    private final AccountService accountService;

    private Account account;

    public AccountEngine(AccountService accountService) {
        this.accountService = accountService;
    }

    public void displayMainMenu() {

        String prompt = "Нажмите: \n \"1\" чтобы зарегистрироваться, или \n \"2\" чтобы залогиниться.";
        System.out.println(prompt);

        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();



        while (choice != 1 || choice != 2) {
            System.out.println(prompt);
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    registration(scanner);
                    break;
                case 2:
                    logIn(scanner);
                    break;
                default:
                    throw new UnsupportedOperationException(choice + "not supported");
            }
        }
    }

    private Account logIn(Scanner scanner) {
        System.out.println("Введите логин и пароль");
        System.out.println("Введите login");
        String login = scanner.next();
        System.out.println("Введите пароль");
        String password = scanner.next();
        return accountService.get(login, password);
    }

    private void registration(Scanner scanner) {
        System.out.println("Вы будете перенаправлены на регистрацию");
        System.out.println("Введите login");
        String login = scanner.next();
        System.out.println("Введите пароль");
        String password = scanner.next();
        accountService.create(login, password);
    }

    public void displayUserMenu() {

        showMenuOptions();

        String prompt = "Выберите задачу";

        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();

        while (choice != 1 || choice != 2 || choice != 3 || choice != 4) {

            System.out.println(prompt);
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    createNewTask(scanner);
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

    private void createNewTask(Scanner scanner) {
        System.out.println("Добавьте новое задание");
        String task = scanner.next();
        accountService.createTask(account, task);
    }

    private void showTaskAdded(){
        accountService.showTasks(account);
    }
}
