package me.dev.service;

import me.dev.dto.AccountDto;
import me.dev.dto.datagrid.DataSourceResponse;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface AccountService {

    AccountDto createNew(AccountDto account);


    DataSourceResponse<AccountDto> getAccountList();
}
