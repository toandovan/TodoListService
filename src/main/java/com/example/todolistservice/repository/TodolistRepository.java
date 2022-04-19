package com.example.todolistservice.repository;

import com.example.todolistservice.entity.Todolist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface TodolistRepository extends JpaRepository<Todolist,Long> {
    Todolist getById(String id);

    void deleteById(String id);
}
