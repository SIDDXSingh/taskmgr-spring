package com.example.taskmgrspring.notes;

import com.example.taskmgrspring.common.ModelMapperList;
import com.example.taskmgrspring.notes.dtos.CreateNotesDto;
import com.example.taskmgrspring.notes.dtos.NotesResponseDto;
import com.example.taskmgrspring.tasks.TaskEntity;
import com.example.taskmgrspring.tasks.TaskRepository;
import com.example.taskmgrspring.tasks.dtos.CreateTaskDto;
import com.example.taskmgrspring.tasks.dtos.TaskResponseDto;
import com.example.taskmgrspring.tasks.exception.TaskNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
public class NotesService {


    private final NotesRepository notesRepository;
    private final ModelMapper modelMapper;
    private final ModelMapperList modelMapperList;
    public NotesService(NotesRepository notesRepository, ModelMapper modelMapper, ModelMapperList modelMapperList) {
        this.notesRepository = notesRepository;
        this.modelMapper = modelMapper;
        this.modelMapperList = modelMapperList;
    }

    public NotesResponseDto createNote(CreateNotesDto newNote)
    {
        NotesEntity note=modelMapper.map(newNote, NotesEntity.class);
        NotesEntity savedNote = notesRepository.save(note);
        return modelMapper.map(savedNote, NotesResponseDto.class);
    }
    public NotesResponseDto getNoteById(@PathVariable("taskId") Long taskId)
    {

        NotesEntity notes=notesRepository.findById(taskId).orElseThrow(() -> new TaskNotFoundException(taskId));
        return modelMapper.map(notes, NotesResponseDto.class);
    }

    public List<NotesResponseDto> getAllNotes() {
        List<NotesEntity>notesEntities=notesRepository.findAll();
        return modelMapperList.mapList(notesEntities,NotesResponseDto.class);
    }

}
