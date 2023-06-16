package com.example.taskmgrspring.notes.dtos;

import com.example.taskmgrspring.notes.NotesEntity;
import com.example.taskmgrspring.tasks.TaskEntity;
import lombok.Data;

import java.util.Date;
import java.util.List;
@Data
public class NotesResponseDto {
    private Long id;
    private String title;
    private String description;
    private TaskEntity task;
}
