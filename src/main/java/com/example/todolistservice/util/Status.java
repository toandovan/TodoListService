package com.example.todolistservice.util;

public enum Status {
    NEW("New"),
    INP("In Progress"),
    FIN("Finish");

    private String status;

    Status(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}