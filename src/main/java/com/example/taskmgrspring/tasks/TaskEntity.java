package com.example.taskmgrspring.tasks;


import com.example.taskmgrspring.notes.NotesEntity;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity(name = "tasks")
public class TaskEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String title;
    private String description;
    private Boolean completed;
    private Date dueDate;

    @OneToMany(targetEntity=NotesEntity.class,cascade = CascadeType.ALL , fetch = FetchType.LAZY,mappedBy = "tasks",orphanRemoval = true)
    @JsonManagedReference
    private List<NotesEntity> notes;

    public void addNotes(NotesEntity notesEntity)
    {
        this.notes.add(notesEntity);
    }
    public void addAllNotes(List<NotesEntity> notesEntity)
    {
        this.notes.addAll(notesEntity);
    }
    public void setTasksOfNotes(TaskEntity task)
    {
        for (NotesEntity obj : notes) {
            obj.setTasks(task);
        }
    }
}
