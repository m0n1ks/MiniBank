package com.example.MiniBank.repository;

import com.example.MiniBank.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {

    // SELECT * FROM transactions WHERE account_id = ?
    List<Transaction> findByAccountId(Long accountId);
}