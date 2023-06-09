package com.example.taskmgrspring.tasks.dtos;

import com.example.taskmgrspring.notes.NotesEntity;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class CreateTaskDto {
    private String title;
    private String Description;
    private Date dueDate;
    private List<NotesEntity> notes;
}
