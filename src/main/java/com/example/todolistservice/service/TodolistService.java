package com.example.todolistservice.service;

import com.example.todolistservice.entity.Todolist;
import com.example.todolistservice.repository.TodolistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Service
public class TodolistService {
    @Autowired
    private TodolistRepository todolistRepository;

    //read
    public List<Todolist> findAll(){
        return todolistRepository.findAll();
    }

    public Todolist findById(String id) {
        return todolistRepository.getById(id);
    }

    public Todolist save(Todolist todolist){
        return todolistRepository.save(todolist);
    }

    //delete
    public void deleteById(String id){
        todolistRepository.deleteById(id);
    }
}
