package com.todo.service;

import com.todo.domain.Account;
import com.todo.repository.AccountRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;
@Slf4j
@Service
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;

    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public Account create(String login, String password) {
        log.info("Creating account with {} login and {} password", login, password);
        Account newAccount = new Account();
        newAccount.setId(UUID.randomUUID());
        newAccount.setLogin(login);
        newAccount.setPassword(password);

        return accountRepository.save(newAccount);
    }

    @Override
    public Account get(String login) {
        return accountRepository.findByLogin(login);
    }

    @Override
    public void delete(String login) {
        accountRepository.delete(get(login));
    }
}