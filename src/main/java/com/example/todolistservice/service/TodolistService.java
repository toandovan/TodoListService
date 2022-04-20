package com.example.todolistservice.service;

import com.example.todolistservice.entity.Todolist;
import com.example.todolistservice.entity.UserDto;
import com.example.todolistservice.repository.TodolistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.circuitbreaker.CircuitBreakerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class TodolistService {
    @Autowired
    private CircuitBreakerFactory cbFactory;
    @Autowired
    private TodolistRepository todolistRepository;

    public List<Todolist> findAll() {
        return todolistRepository.findAll();
    }

    public Todolist findById(String id) {
        return todolistRepository.getById(id);
    }

    public Todolist save(Todolist todolist) {
        return todolistRepository.save(todolist);
    }

    public void deleteById(long id) {
        todolistRepository.deleteById(id);
    }

    public ResponseEntity<UserDto> getUserData(String jwtToken) {

        String uri = "http://localhost:9000/auth/getUserData";
        RestTemplate restTemplate = new RestTemplate();

        return cbFactory.create("circuitbreaker").run(() -> restTemplate.postForEntity(uri,jwtToken,UserDto.class), throwable -> null);
    }
}