package com.example.taskmgrspring.tasks;

import com.example.taskmgrspring.tasks.dtos.CreateTaskDto;
import com.example.taskmgrspring.tasks.dtos.TaskResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/tasks/")

public class TaskController
{
    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping("")
    public String getTasks()
    {
        return "";//TODO: remove the string
    }
    @PostMapping("")
    public ResponseEntity<TaskResponseDto> createTask(@RequestBody CreateTaskDto newTask)
    {
        TaskResponseDto savedTask= taskService.createTask(newTask);
        return ResponseEntity.created(URI.create("http://localhost:8383/tasks/"+savedTask.getId())).body(savedTask);

    }

}
