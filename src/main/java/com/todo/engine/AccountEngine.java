package com.todo.engine;

import com.todo.domain.Account;
import com.todo.service.AccountService;

import java.util.Scanner;

public class AccountEngine {

    private final AccountService accountService;

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
            choice = scanner.nextInt();;
            if (choice == 1) {
                System.out.println("Вы будете перенаправлены на регистрацию");
                System.out.println("Введите login");
                String login = scanner.next();
                System.out.println("Введите пароль");
                String password = scanner.next();
                Account account = new Account(login,password);
                break;
            }
            if (choice == 2) {
                System.out.println("Введите логин и пароль");
                break;
            }

        }

    }


    public void displayUserMenu() {
    }
}
