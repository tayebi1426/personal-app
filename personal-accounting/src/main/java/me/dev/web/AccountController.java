package me.dev.web;

import me.dev.dto.AccountDto;
import me.dev.service.AccountService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/account")
public class AccountController {


    private AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }


    @PostMapping()
    public ResponseEntity<String> createNew(Authentication authentication, String name, Integer initialBalance) {
        System.out.println(authentication.getPrincipal());
        accountService.createNew(new AccountDto(name,initialBalance));
        return ResponseEntity.ok("ok");
    }
}
