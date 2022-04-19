package com.example.todolistservice.controller;

import com.example.todolistservice.entity.Todolist;
import com.example.todolistservice.service.TodolistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/todolist")
public class TodolistController {

    @Autowired
    private TodolistService todolistService;

    @GetMapping
    public List<Todolist> findAll(){
        return todolistService.findAll();
    }

    @GetMapping("/{id}")
    public Todolist findById(@PathVariable String id){
        return todolistService.findById(id);
    }

    @PostMapping
    public Todolist create(@RequestBody Todolist todolist) {
        return todolistService.save(todolist);
    }

    @PostMapping("/{id}")
    public  Todolist update(@RequestBody Todolist todolist){
        return todolistService.save(todolist);
    }

    @DeleteMapping("{/id}")
    public void deleteById(@PathVariable String id){
        todolistService.deleteById(id);
    }

}
