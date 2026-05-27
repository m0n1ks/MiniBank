package com.example.MiniBank.service;

import com.example.MiniBank.entity.Client;
import com.example.MiniBank.repository.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service  // Spring создаст один объект этого класса на всё приложение
@RequiredArgsConstructor  // Lombok создаст конструктор — Spring через него передаст репозиторий
public class ClientService {

    // final означает: поле обязательно передаётся через конструктор
    // Spring сам найдёт ClientRepository и "вставит" его сюда
    private final ClientRepository clientRepository;

    // Вернуть всех клиентов из БД
    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }

    // Найти клиента или выбросить ошибку если не существует
    public Client getClientById(Long id) {
        return clientRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Клиент не найден: " + id));
    }

    // Создать клиента с проверкой уникальности email
    public Client createClient(Client client) {
        if (clientRepository.findByEmail(client.getEmail()).isPresent()) {
            throw new RuntimeException("Email уже занят: " + client.getEmail());
        }
        return clientRepository.save(client);
    }

    public void deleteClient(Long id) {
        clientRepository.deleteById(id);
    }
}