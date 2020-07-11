package com.todo.repository;

import com.todo.domain.Account;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Map;

public class AccountRepositoryFileStorage implements AccountRepository {

    private static final String FILE_NAME = "storage.db";

    private Map<String,Account> fileStorage;

    public AccountRepositoryFileStorage() {
        try {
            fileStorage = readFromStorage();
        }catch (Exception e) {
            fileStorage = new HashMap<>();
            writeToStorage(fileStorage);
        }
    }

    @Override
    public void add(Account account) {
        fileStorage = readFromStorage();
        if (!fileStorage.containsKey(account.getLogin())){
            fileStorage.put(account.getLogin(),account);
            writeToStorage(fileStorage);
            System.out.println(String.format("%s is added ",account.getLogin()));
        } else {
            System.err.println(String.format("%s if exists in Storage",account.getLogin()));
        }

    }

    @Override
    public Account get(String login, String password) {
        fileStorage = readFromStorage();
        if (fileStorage.containsKey(login)) {
            Account account = fileStorage.get(login);
            if (password.equals(account.getPassword())) {
                return account;
            } else {
                System.err.println(String.format("%s wrong password for ", login));
                throw new NullPointerException();
            }
        } else {
            System.err.println(String.format("%s doesn't exist in Storage ",login));
            throw new NullPointerException();
        }
    }

    @Override
    public void update(Account account) {
        Account persistedAccount = get(account.getLogin(),account.getPassword());
        remove(persistedAccount.getLogin(),persistedAccount.getPassword());
        add(account);
    }

    @Override
    public void remove(String login, String password) {
        Account persistedAccount = get(login,password);
        if (persistedAccount != null){
            fileStorage.remove(login);
        }
    }

    private void writeToStorage(Map<String,Account> fileStorage) {
        try(FileOutputStream fileOutputStream = new FileOutputStream(FILE_NAME);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {
            objectOutputStream.writeObject(fileStorage);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    private Map<String,Account> readFromStorage() {
        try (FileInputStream fileInputStream = new FileInputStream(FILE_NAME);
             ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {
            return (Map<String, Account>) objectInputStream.readObject();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}