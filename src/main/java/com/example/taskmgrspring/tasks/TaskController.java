package com.example.taskmgrspring.tasks;

import com.example.taskmgrspring.tasks.dtos.CreateTaskDto;
import com.example.taskmgrspring.tasks.dtos.PatchTaskDto;
import com.example.taskmgrspring.tasks.dtos.TaskResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/tasks/")

public class TaskController
{

    @Autowired
    private final TaskService taskService;

    public TaskController(TaskService taskService, TaskRepository taskRepository) {
        this.taskService = taskService;

    }


    @GetMapping("")
    public ResponseEntity<List<TaskResponseDto>> getTasks()
    {
        List<TaskResponseDto> allTasks=taskService.getAllTasks();
        return ResponseEntity.ok(allTasks);
    }



    @GetMapping("{taskId}")
    public ResponseEntity<TaskResponseDto> getTasksById(@PathVariable("taskId") Long id)
    {
        TaskResponseDto taskResponseDto=taskService.getTaskById(id);
        return ResponseEntity.ok(taskResponseDto);
    }


    @PostMapping("")
    public ResponseEntity<TaskResponseDto> createTask(@RequestBody CreateTaskDto newTask)
    {
        TaskResponseDto savedTask= taskService.createTask(newTask);

        return ResponseEntity.created(URI.create("http://localhost:8383/tasks/"+savedTask.getId())).body(savedTask);
    }

    @PatchMapping("{taskId}")
    public ResponseEntity<TaskResponseDto> UpdateTask(@RequestBody PatchTaskDto patchTaskDto, @PathVariable("taskId") Long id)
    {
        TaskResponseDto taskResponseDto=taskService.updateTaskById(patchTaskDto,id);
        return ResponseEntity.ok(taskResponseDto);
    }
    @DeleteMapping("{taskId}")
    public ResponseEntity<?> DeleteTask(@PathVariable("taskId") Long id)
    {
        taskService.deleteTaskbyId(id);
        return ResponseEntity.noContent().build();
    }
}
