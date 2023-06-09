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
import org.springframework.scheduling.config.Task;
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

    public NotesResponseDto createNote(Long taskId,CreateNotesDto newNote)
    {
        TaskEntity task=notesRepository.findByTaskTaskId(taskId);
        NotesEntity note=modelMapper.map(newNote, NotesEntity.class);
        note.setTask(task);
        NotesEntity savedNote = notesRepository.save(note);
        return modelMapper.map(savedNote, NotesResponseDto.class);
    }
    public List<NotesResponseDto>getNoteByTaskId(Long taskId)
    {

        List<NotesEntity>notes=notesRepository.findByTaskTaskId(taskId).getNotes();
        return modelMapperList.mapList(notes,NotesResponseDto.class);
    }

}
