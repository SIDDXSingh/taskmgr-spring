package com.example.taskmgrspring.tasks.exception;

public class TaskNotFoundException extends IllegalArgumentException{
    public TaskNotFoundException(Long id) {
        super("Task with id = " + id + " not found");
    }
}
