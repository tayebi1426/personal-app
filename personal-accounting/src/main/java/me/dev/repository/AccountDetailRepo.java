package me.dev.repository;

import me.dev.entity.AccountDetail;
import org.springframework.stereotype.Repository;


@Repository
public interface AccountDetailRepo extends AbstractJpaRepository<AccountDetail, Integer>  {
}
