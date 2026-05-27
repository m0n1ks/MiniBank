package com.example.MiniBank.repository;

import com.example.MiniBank.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

// JpaRepository<Client, Long> — работаем с таблицей Client, ключ типа Long
// Бесплатно получаем: findAll, findById, save, deleteById и ещё 10+ методов
@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

    // Spring видит слово "By Email" и сам пишет:
    // SELECT * FROM clients WHERE email = ?
    Optional<Client> findByEmail(String email);
}