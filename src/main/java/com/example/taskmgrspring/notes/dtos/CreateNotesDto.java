package com.example.taskmgrspring.notes.dtos;

import com.example.taskmgrspring.notes.NotesEntity;
import com.example.taskmgrspring.tasks.TaskEntity;
import lombok.Data;

import java.util.Date;
import java.util.List;
@Data
public class CreateNotesDto {
    private String title;
    private String Description;
}
