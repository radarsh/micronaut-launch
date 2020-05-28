package com.example.controller;

import com.example.service.TodoService;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;

@Controller
public class TodoController {

    private final TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @Get("/password")
    public String getPassword() {
        return todoService.getPassword();
    }
}
