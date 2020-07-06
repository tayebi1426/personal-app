package me.dev.service.impl;

import me.dev.dto.AccountDto;
import me.dev.dto.datagrid.DataSourceResponse;
import me.dev.entity.Account;
import me.dev.repository.AccountRepo;
import me.dev.service.AccountService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

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

    @Override
    @Transactional(readOnly = true)
    public DataSourceResponse<AccountDto> getAccountList() {
        List<Account> accountList = accountRepo.findAll();
        List<AccountDto> accountDtoList = accountList.stream().map(AccountDto::new).collect(Collectors.toList());
        return new DataSourceResponse<AccountDto>(accountDtoList.size(),accountDtoList);
    }

    @Transactional
    public AccountDto createNew(Account account) {
        return null;
    }

}
