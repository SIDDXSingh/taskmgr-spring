package com.example.taskmgrspring.tasks;


import com.example.taskmgrspring.tasks.dtos.CreateTaskDto;
import com.example.taskmgrspring.tasks.dtos.TaskResponseDto;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class TaskService {

    private final TaskRepository taskRepository;
    private final ModelMapper modelMapper;
    public TaskService(TaskRepository taskRepository, ModelMapper modelMapper) {
        this.taskRepository = taskRepository;
        this.modelMapper = modelMapper;
    }


    public TaskResponseDto createTask(CreateTaskDto newTask)
    {
        TaskEntity task=modelMapper.map(newTask, TaskEntity.class);
        task.setCompleted(false);
        TaskEntity savedTask=taskRepository.save(task);
        return modelMapper.map(savedTask, TaskResponseDto.class);
    }

}
