package me.dev.repository;


import me.dev.entity.Transaction;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional(readOnly = true)
public interface TransactionRepo extends AbstractJpaRepository<Transaction, Integer> {

}
