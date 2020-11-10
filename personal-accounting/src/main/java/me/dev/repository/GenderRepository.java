package me.dev.repository;

import me.dev.entity.Gender;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional(readOnly = true)
public interface GenderRepository extends AbstractJpaRepository<Gender,Byte> {
}
