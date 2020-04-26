package me.dev.service.impl;

import me.dev.dto.AccountDto;
import me.dev.entity.Account;
import me.dev.repository.AccountRepo;
import me.dev.service.AccountService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {

    private AccountRepo accountRepo;

    public AccountServiceImpl(AccountRepo accountRepo) {
        this.accountRepo = accountRepo;
    }

    @Override
    @Transactional
    public AccountDto createNew(AccountDto accountDto) {
        Account newAccount=new Account(accountDto);
        return createNew(newAccount);
    }
    @Transactional
    public AccountDto createNew(Account account) {
        return null;
    }

}
