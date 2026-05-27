package com.example.MiniBank.repository;

import com.example.MiniBank.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

    // SELECT * FROM accounts WHERE client_id = ?
    List<Account> findByClientId(Long clientId);
}