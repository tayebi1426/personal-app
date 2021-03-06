package me.dev.web;

import me.dev.dto.AccountDto;
import me.dev.dto.CustomUserDetails;
import me.dev.dto.datagrid.DataSourceResponse;
import me.dev.service.AccountService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/account")
@CrossOrigin(origins = "*")
public class AccountController {

    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping(value = "/save", consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<String> save(@RequestBody AccountDto accountDto, Authentication authentication) {
        Assert.hasText(accountDto.getName(), "empty");
        CustomUserDetails principal = (CustomUserDetails) authentication.getPrincipal();
        System.out.println("username : " + principal.getUsername());
        accountService.createNew(accountDto);
        return ResponseEntity.ok("ok");
    }

    @PostMapping("/list")
    public ResponseEntity<DataSourceResponse<AccountDto>> list() {
        return ResponseEntity.ok(accountService.getAccountList());
    }
}
