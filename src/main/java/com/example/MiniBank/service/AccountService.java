package com.example.MiniBank.service;

import com.example.MiniBank.entity.Account;
import com.example.MiniBank.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AccountService {

    private final AccountRepository accountRepository;

    // Все счета конкретного клиента
    public List<Account> getAccountsByClientId(Long clientId) {
        return accountRepository.findByClientId(clientId);
    }

    // Один счёт по id
    public Account getAccountById(Long id) {
        return accountRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Счёт не найден: " + id));
    }

    // Создать счёт
    public Account createAccount(Account account) {
        return accountRepository.save(account);
    }
}