package com.example.MiniBank.controller;

import com.example.MiniBank.entity.Client;
import com.example.MiniBank.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController          // этот класс принимает HTTP запросы и возвращает JSON
@RequestMapping("/api/clients")  // все методы начинаются с /api/clients
@RequiredArgsConstructor
public class ClientController {

    private final ClientService clientService;

    // GET /api/clients → вернуть всех клиентов
    @GetMapping
    public List<Client> getAllClients() {
        return clientService.getAllClients();
    }

    // GET /api/clients/1 → вернуть клиента с id=1
    @GetMapping("/{id}")
    public Client getClient(@PathVariable Long id) {
        return clientService.getClientById(id);
    }

    // POST /api/clients → создать нового клиента
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)  // вернуть статус 201 вместо 200
    public Client createClient(@RequestBody Client client) {
        return clientService.createClient(client);
    }

    // DELETE /api/clients/1 → удалить клиента
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)  // вернуть 204 — удалено, тела нет
    public void deleteClient(@PathVariable Long id) {
        clientService.deleteClient(id);
    }
}