package com.example.taskmgrspring.notes;
import com.example.taskmgrspring.notes.dtos.CreateNotesDto;
import com.example.taskmgrspring.notes.dtos.NotesResponseDto;
import com.example.taskmgrspring.tasks.TaskEntity;
import com.example.taskmgrspring.tasks.dtos.CreateTaskDto;
import com.example.taskmgrspring.tasks.dtos.TaskResponseDto;
import lombok.Data;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/tasks/{taskId}/notes")
@Data
public class NotesController {


    private NotesService notesService;
    @GetMapping("/getnotes/")
    public ResponseEntity<List<NotesResponseDto>> getAllNotesByTaskId(@PathVariable("taskId") Long taskId) {
        List<NotesResponseDto> notesResponseDto=notesService.getNoteByTaskId(taskId);
        return ResponseEntity.ok(notesResponseDto);
    }
    @PostMapping("/addnotes/")
    public ResponseEntity<NotesResponseDto> createTask(@RequestBody CreateNotesDto newNote,@PathVariable("taskId") Long taskId)
    {

        NotesResponseDto savedNotes= notesService.createNote(taskId,newNote);
        return ResponseEntity.created(URI.create("http://localhost:8383/tasks/{taskId}/notes/"+savedNotes.getId())).body(savedNotes);
    }
}
