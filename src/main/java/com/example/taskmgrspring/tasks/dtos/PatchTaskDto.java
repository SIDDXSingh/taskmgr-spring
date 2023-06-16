package com.example.taskmgrspring.tasks.dtos;

import com.example.taskmgrspring.notes.NotesEntity;
import lombok.Data;

import java.util.List;

@Data
public class PatchTaskDto {
    private Boolean completed;
    private Boolean deleteNotes;
    private List<NotesEntity> notes;

}
