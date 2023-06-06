package com.example.taskmgrspring.tasks;

import com.example.taskmgrspring.tasks.dtos.CreateTaskDto;
import com.example.taskmgrspring.tasks.dtos.TaskResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/tasks/")

public class TaskController
{
    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping("/alltasks")
    public ResponseEntity<List<TaskResponseDto>> getTasks()
    {
        List<TaskResponseDto> allTasks=taskService.getAllTaks();
        return ResponseEntity.ok(allTasks);
    }

    @GetMapping("/{taskid}")
    public ResponseEntity<TaskResponseDto> getTasksbyId(@PathVariable("taskid") Long id)
    {
        TaskResponseDto taskResponseDto=taskService.getTaskbyId(id);
        return ResponseEntity.ok(taskResponseDto);
    }


    @PostMapping("")
    public ResponseEntity<TaskResponseDto> createTask(@RequestBody CreateTaskDto newTask)
    {
        TaskResponseDto savedTask= taskService.createTask(newTask);
        return ResponseEntity.created(URI.create("http://localhost:8383/tasks/"+savedTask.getId())).body(savedTask);

    }

}
