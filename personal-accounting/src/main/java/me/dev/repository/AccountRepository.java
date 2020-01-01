package me.dev.repository;

import me.dev.entity.Account;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional(readOnly = true)
public interface AccountRepository extends AbstractJpaRepository<Account, Integer> {

}
