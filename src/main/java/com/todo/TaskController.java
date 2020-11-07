package com.todo;

import com.todo.service.TasksService;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TaskController {

    private final TasksService tasksService;

    public TaskController(TasksService tasksService) {
        this.tasksService = tasksService;
    }
}
