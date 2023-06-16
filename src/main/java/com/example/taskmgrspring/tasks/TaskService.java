package com.example.taskmgrspring.tasks;


import com.example.taskmgrspring.common.ModelMapperList;
import com.example.taskmgrspring.notes.NotesEntity;
import com.example.taskmgrspring.notes.NotesRepository;
import com.example.taskmgrspring.tasks.dtos.CreateTaskDto;
import com.example.taskmgrspring.tasks.dtos.PatchTaskDto;
import com.example.taskmgrspring.tasks.dtos.TaskResponseDto;
import com.example.taskmgrspring.tasks.exception.TaskNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;


@Service
public class TaskService {

   @Autowired
    private final TaskRepository taskRepository;

   @Autowired
   private final NotesRepository notesRepository;
    private final ModelMapper modelMapper;
    private final ModelMapperList modelMapperList;
    public TaskService(TaskRepository taskRepository, NotesRepository notesRepository, ModelMapper modelMapper, ModelMapperList modelMapperList) {

        this.taskRepository = taskRepository;
        this.notesRepository = notesRepository;
        this.modelMapper = modelMapper;
        this.modelMapperList = modelMapperList;
    }


    public TaskResponseDto createTask(CreateTaskDto newTask)
    {
        TaskEntity task=modelMapper.map(newTask, TaskEntity.class);
        task.setCompleted(false);
        List<NotesEntity>notes=task.getNotes();
        task.setTasksOfNotes(task);
        TaskEntity savedTask=taskRepository.save(task);
        return modelMapper.map(savedTask, TaskResponseDto.class);
    }

    public TaskResponseDto getTaskById(@PathVariable("taskId") Long id)
    {
        TaskEntity task=taskRepository.findById(id).orElseThrow(() -> new TaskNotFoundException(id));
        task.getNotes();
        return modelMapper.map(task, TaskResponseDto.class);
    }

    public List<TaskResponseDto> getAllTasks() {
        List<TaskEntity>taskEntities=taskRepository.findAll();
        return modelMapperList.mapList(taskEntities,TaskResponseDto.class);
    }
    public TaskResponseDto updateTaskById(PatchTaskDto patchTaskDto, @PathVariable("taskId") Long id)
    {
        TaskEntity task=taskRepository.findById(id).orElseThrow(() -> new TaskNotFoundException(id));
        task.setCompleted(patchTaskDto.getCompleted());
        task.addAllNotes(patchTaskDto.getNotes());
        task.setTasksOfNotes(task);


        TaskEntity savedTask=taskRepository.save(task);
        return modelMapper.map(savedTask,TaskResponseDto.class);
    }
    public void deleteTaskbyId(@PathVariable("taskId") Long id)
    {
        taskRepository.deleteById(id);
    }




}
