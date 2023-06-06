package com.example.taskmgrspring.notes;

import com.example.taskmgrspring.notes.dtos.CreateNotesDto;
import com.example.taskmgrspring.notes.dtos.NotesResponseDto;
import com.example.taskmgrspring.tasks.dtos.CreateTaskDto;
import com.example.taskmgrspring.tasks.dtos.TaskResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/tasks/{taskId}/notes")
public class NotesController {


    private NotesService notesService;
    @GetMapping("/")
    public ResponseEntity<NotesResponseDto> getAllNotesByTaskId(@PathVariable("taskId") Long taskId) {
        NotesResponseDto notesResponseDto=notesService.getNoteById(taskId);
        return ResponseEntity.ok(notesResponseDto);
    }
    @PostMapping("/")
    public ResponseEntity<NotesResponseDto> createTask(@RequestBody CreateNotesDto newNote,Long taskId)
    {
        NotesResponseDto savedNotes= notesService.createNote(newNote);
        return ResponseEntity.created(URI.create("http://localhost:8383/tasks/"+savedNotes.getId())).body(savedNotes);
    }
}
