package me.dev.web;


import me.dev.dto.TransactionDto;
import me.dev.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/transaction")
@CrossOrigin(origins = "*")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @PostMapping(value = "/save", consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<String> save(@RequestBody
                                       @Validated TransactionDto transactionDto, Authentication authentication) {
        transactionService.save(transactionDto);
        return ResponseEntity.ok("ok");
    }

}
