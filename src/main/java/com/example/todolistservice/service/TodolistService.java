package com.example.todolistservice.service;

import com.example.todolistservice.entity.Todolist;
import com.example.todolistservice.entity.UserDto;
import com.example.todolistservice.repository.TodolistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.circuitbreaker.CircuitBreakerFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class TodolistService {
    @Autowired
    private CircuitBreakerFactory cbFactory;
    @Autowired
    private TodolistRepository todolistRepository;
    @Autowired
    private TodoUtil todoUtil;

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
        return cbFactory.create("circuitbreaker").run(() -> todoUtil.getUserData(jwtToken), throwable -> null);
    }
}