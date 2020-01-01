package me.dev.service.impl;

import me.dev.dto.AccountDto;
import me.dev.entity.Account;
import me.dev.repository.AccountRepository;
import me.dev.service.AccountService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AccountServiceImpl implements AccountService {

    private AccountRepository accountRepository;

    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    @Transactional
    public AccountDto createNew(AccountDto account) {
        Account newAccount=new Account();
        return createNew(newAccount);
    }

    @Transactional
    public AccountDto createNew(Account account) {
        accountRepository.save(account);
        return null;
    }

}
