package com.example.taskmgrspring.tasks;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Date;

@DataJpaTest
public class TaskServiceTest {
    @Autowired private TaskRepository taskRepository;



    @Test
    public void testCreateTask()
    {
        TaskService taskService=new TaskService(taskRepository);
        TaskEntity task=taskService.createTask("Test Task","Test Description", new Date());
        System.out.println(task);
    }

}
