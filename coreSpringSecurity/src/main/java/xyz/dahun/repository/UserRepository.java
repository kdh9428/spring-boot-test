package xyz.dahun.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import xyz.dahun.domain.entity.Account;

public interface UserRepository extends JpaRepository<Account, Long> {

    Account findByUsername(String username);
}