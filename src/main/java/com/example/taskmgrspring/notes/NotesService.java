package com.example.taskmgrspring.notes;

import com.example.taskmgrspring.common.ModelMapperList;
import com.example.taskmgrspring.notes.dtos.CreateNotesDto;
import com.example.taskmgrspring.notes.dtos.NotesResponseDto;
import com.example.taskmgrspring.tasks.TaskEntity;
import com.example.taskmgrspring.tasks.TaskRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
public class NotesService {


    @Autowired
    private final NotesRepository notesRepository;
    @Autowired
    private final TaskRepository taskRepository;
    private final ModelMapper modelMapper;
    private final ModelMapperList modelMapperList;
    public NotesService(NotesRepository notesRepository, TaskRepository taskRepository, ModelMapper modelMapper, ModelMapperList modelMapperList) {
        this.notesRepository = notesRepository;
        this.taskRepository = taskRepository;
        this.modelMapper = modelMapper;
        this.modelMapperList = modelMapperList;
    }

    /*public NotesResponseDto createNote(Long taskId, CreateNotesDto newNote)
    {
        TaskEntity task = taskRepository.findById(taskId).get();
        NotesEntity note=modelMapper.map(newNote, NotesEntity.class);
        task.addNotes(note);
        note.setTask(task);//TODO:later
        NotesEntity savedNote = notesRepository.save(note);
        return modelMapper.map(savedNote, NotesResponseDto.class);//TODO:later
    }*/

   /* public List<NotesResponseDto>getNoteByTaskId(Long taskId)
    {
        return null; //TODO:return Later
    }*/
    public List<NotesResponseDto>getAllnotes()
    {
        List<NotesEntity> notes= notesRepository.findAll();
        return modelMapperList.mapList(notes,NotesResponseDto.class);
    }
    public List<NotesResponseDto>getNotesByTaskId(@PathVariable("taskId") Long id)
    {
        TaskEntity task=taskRepository.findById(id).get();
        List<NotesEntity> notes= task.getNotes();
        return modelMapperList.mapList(notes,NotesResponseDto.class);
    }
    public NotesResponseDto createNotes(CreateNotesDto createNotesDto,Long id)
    {
        NotesEntity notes=modelMapper.map(createNotesDto,NotesEntity.class);
        notes.setTasks(taskRepository.findById(id).get());
        NotesEntity savedNotes=notesRepository.save(notes);
        return modelMapper.map(savedNotes,NotesResponseDto.class);
    }

    public void deleteNotesById(@PathVariable("taskId") Long taskID,@PathVariable("noteId") Long noteId)
    {
        NotesEntity notes=notesRepository.findById(noteId).get();
        TaskEntity task=notes.getTasks();
        notes.setTasks(null);
        task.getNotes().remove(notes);
        notesRepository.deleteById(noteId);
    }
}
