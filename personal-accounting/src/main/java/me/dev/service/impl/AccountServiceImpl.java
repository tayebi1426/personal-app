package me.dev.service.impl;

import me.dev.dto.AccountDto;
import me.dev.entity.Account;
import me.dev.entity.AccountDetail;
import me.dev.repository.AccountDetailRepo;
import me.dev.repository.AccountRepo;
import me.dev.service.AccountService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {

    private AccountRepo accountRepo;
    private AccountDetailRepo accountDetailRepo;

    public AccountServiceImpl(AccountRepo accountRepo, AccountDetailRepo accountDetailRepo) {
        this.accountRepo = accountRepo;
        this.accountDetailRepo = accountDetailRepo;
    }

    @Override
    @Transactional
    public AccountDto createNew(AccountDto account) {
        Account newAccount=new Account(account);
        return createNew(newAccount);
    }

    @Override
    public List<AccountDto> findAll() {
        List<Account> accountList = accountRepo.findAll();
        return (List<AccountDto>) accountList.stream().map(null);
    }

    @Transactional
    public AccountDto createNew(Account account) {
        AccountDetail accountDetail=new AccountDetail();
        accountDetail.setAccount(account);
        accountRepo.save(account);
        accountDetailRepo.save(accountDetail);
        System.out.println(accountDetail.getId());
        return null;
    }

}
