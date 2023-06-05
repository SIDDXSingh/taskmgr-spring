package com.example.taskmgrspring.tasks.dtos;

import lombok.Data;

import java.util.Date;
@Data
public class CreateTaskDto {
    String title;
    String Description;
    Date dueDate;

}
