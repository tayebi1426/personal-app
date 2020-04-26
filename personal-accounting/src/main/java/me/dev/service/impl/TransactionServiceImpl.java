package me.dev.service.impl;

import me.dev.dto.TransactionDto;
import me.dev.entity.Account;
import me.dev.entity.Transaction;
import me.dev.entity.TransactionType;
import me.dev.repository.TransactionRepo;
import me.dev.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TransactionServiceImpl implements TransactionService {

    @Autowired
    TransactionRepo transactionRepo;

    @Override
    @Transactional
    public TransactionDto save(TransactionDto transactionDto) {
        Transaction transaction = transactionRepo.save(convertDtoToEntity(transactionDto));
        return new TransactionDto(transaction.getId());
    }

    private Transaction convertDtoToEntity(TransactionDto dto) {
        Transaction transaction = new Transaction();
        transaction.setTransactionDate(dto.getTransactionDate());
        transaction.setTransactionAmount(dto.getTransactionAmount());
        transaction.setDescription(dto.getDescription());
        transaction.setAccount(new Account(dto.getAccountId()));
        transaction.setTransactionType(new TransactionType(dto.getTransactionTypeId()));
        return transaction;
    }
}
