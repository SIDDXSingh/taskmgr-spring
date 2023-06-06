package com.example.taskmgrspring.tasks;


import com.example.taskmgrspring.common.ModelMapperList;
import com.example.taskmgrspring.tasks.dtos.CreateTaskDto;
import com.example.taskmgrspring.tasks.dtos.TaskResponseDto;
import com.example.taskmgrspring.tasks.exception.TaskNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class TaskService {

    private final TaskRepository taskRepository;
    private final ModelMapper modelMapper;
    private final ModelMapperList modelMapperList;
    public TaskService(TaskRepository taskRepository, ModelMapper modelMapper, ModelMapperList modelMapperList) {
        this.taskRepository = taskRepository;
        this.modelMapper = modelMapper;
        this.modelMapperList = modelMapperList;
    }


    public TaskResponseDto createTask(CreateTaskDto newTask)
    {
        TaskEntity task=modelMapper.map(newTask, TaskEntity.class);
        task.setCompleted(false);
        TaskEntity savedTask=taskRepository.save(task);
        return modelMapper.map(savedTask, TaskResponseDto.class);
    }
    public TaskResponseDto getTaskbyId(Long id)
    {
        TaskEntity task=taskRepository.findById(id).orElseThrow(() -> new TaskNotFoundException(id));
        return modelMapper.map(task, TaskResponseDto.class);
    }

    public List<TaskResponseDto> getAllTaks() {
        List<TaskEntity>taskEntities=taskRepository.findAll();
        return modelMapperList.mapList(taskEntities,TaskResponseDto.class);
    }
}
