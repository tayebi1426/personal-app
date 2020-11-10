package me.dev.repository;

import me.dev.entity.Person;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional(readOnly = true)
public interface PersonRepository extends AbstractJpaRepository<Person, Integer> {

}
