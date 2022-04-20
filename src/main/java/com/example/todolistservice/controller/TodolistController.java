package com.example.todolistservice.controller;

import com.example.todolistservice.entity.UserDto;
import com.example.todolistservice.util.Status;
import org.apache.http.client.methods.HttpDelete;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.todolistservice.entity.Todolist;
import com.example.todolistservice.service.TodolistService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@RestController
@RequestMapping(value = "/todolist")
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
    public ResponseEntity create(@RequestBody Todolist todolist, @RequestHeader(name = "Authorization") String jwtToken) {
        todolist.setStatus(Status.NEW);
        //get user data
        String uri = "http://localhost:8000/auth/getUserData";
        ResponseEntity<UserDto> data=todolistService.getUserData(jwtToken);
        if(data.equals(null)){
            return new ResponseEntity(null,HttpStatus.BAD_REQUEST);
        }
        todolist.setUserId(data.getBody().getId());
        return new ResponseEntity(todolistService.save(todolist),HttpStatus.OK);
    }

    @PostMapping("/{id}")
    public  ResponseEntity update(@PathVariable long id,@RequestBody Todolist todolist, @RequestHeader(name = "Authorization") String jwtToken){
        String uri = "http://localhost:8000/auth/getUserData";
        ResponseEntity<UserDto> data=todolistService.getUserData(jwtToken);
        if(data.equals(null)){
            return new ResponseEntity(null,HttpStatus.BAD_REQUEST);
        }
        todolist.setId(id);
        todolist.setUserId(data.getBody().getId());
        return new ResponseEntity(todolistService.save(todolist),HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity deleteById(@PathVariable long id){
        todolistService.deleteById(id);
        return new ResponseEntity(null,HttpStatus.OK);
    }

}