package com.example.taskmgrspring.tasks;


import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class TaskService {

    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }


    public TaskEntity createTask(String title, String Description, Date dueDate)
    {
        TaskEntity task=new TaskEntity();
        task.setTitle(title);
        task.setDescription(Description);
        task.setCompleted(false);
        task.setDueDate(dueDate);
        return taskRepository.save(task);
    }

}
