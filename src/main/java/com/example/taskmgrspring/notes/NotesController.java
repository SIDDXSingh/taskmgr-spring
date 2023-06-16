package com.example.taskmgrspring.notes;
import com.example.taskmgrspring.notes.dtos.CreateNotesDto;
import com.example.taskmgrspring.notes.dtos.NotesResponseDto;
import com.example.taskmgrspring.tasks.TaskEntity;
import com.example.taskmgrspring.tasks.dtos.CreateTaskDto;
import com.example.taskmgrspring.tasks.dtos.TaskResponseDto;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/tasks/")
@Data
public class NotesController {


    @Autowired
    private NotesService notesService;
    /*@GetMapping("{taskId}/getnotes/")
    public ResponseEntity<List<NotesResponseDto>> getAllNotesByTaskId(@PathVariable("taskId") Long taskId) {
        List<NotesResponseDto> notesResponseDto=notesService.getNoteByTaskId(taskId);
        return ResponseEntity.ok(notesResponseDto);//TODO:later
    }*/
    @GetMapping("notes")
    public ResponseEntity<List<NotesResponseDto>> getAllNotes() {
        List<NotesResponseDto> notesResponseDto=notesService.getAllnotes();
        return ResponseEntity.ok(notesResponseDto);
    }
    @GetMapping("{taskId}/notes")
    public ResponseEntity<List<NotesResponseDto>> getAllNotesByTaskId(@PathVariable("taskId")Long id) {
        List<NotesResponseDto> notesResponseDto=notesService.getNotesByTaskId(id);
        return ResponseEntity.ok(notesResponseDto);
    }
    @PostMapping("{taskId}/notes")
    public ResponseEntity<NotesResponseDto> createNotes(@RequestBody CreateNotesDto createNotesDto,@PathVariable("taskId")Long id)
    {
        NotesResponseDto notesResponseDto=notesService.createNotes(createNotesDto,id);
        return ResponseEntity.ok(notesResponseDto);
    }
    @DeleteMapping("{taskId}/notes/{noteId}")
    public ResponseEntity<?>DeleteNotesById(@PathVariable("taskId")Long taskID,@PathVariable("noteId")Long noteId)
    {



        notesService.deleteNotesById(taskID,noteId);
        return ResponseEntity.noContent().build();



    }

    /*@PostMapping("{taskId}/addnotes/")
    public ResponseEntity<NotesResponseDto> createTask(@RequestBody CreateNotesDto newNote,@PathVariable("taskId") Long taskId)
    {
        NotesResponseDto savedNotes= notesService.createNote(taskId,newNote);
        return ResponseEntity.created(URI.create("http://localhost:8383/tasks/{taskId}/notes/"+savedNotes.getId())).body(savedNotes);
    }*/
}
