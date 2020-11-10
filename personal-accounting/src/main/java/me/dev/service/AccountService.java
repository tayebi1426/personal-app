package me.dev.service;

import me.dev.dto.AccountDto;
import me.dev.dto.datagrid.DataSourceResponse;

public interface AccountService {

    AccountDto createNew(AccountDto account);


    DataSourceResponse<AccountDto> getAccountList();
}
